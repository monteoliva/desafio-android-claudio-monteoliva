package br.com.desafioandroidclaudiomonteoliva.model.character

import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import com.google.gson.Gson

import br.com.desafioandroidclaudiomonteoliva.model.enums.Endpoints
import br.com.desafioandroidclaudiomonteoliva.model.gson.character.Characters
import br.com.desafioandroidclaudiomonteoliva.model.gson.character.Result
import br.com.desafioandroidclaudiomonteoliva.presenter.character.MVP
import br.com.desafioandroidclaudiomonteoliva.utils.Constantes
import br.com.desafioandroidclaudiomonteoliva.utils.Utils

class Model(private val presenter: MVP.Presenter): MVP.Model {
    private lateinit var requestQueue: RequestQueue

    private var offset: Int = 0
    private val LIMIT: Int = 20
    private var TOTAL: Int = 0
    private val baseUrl: String = Constantes.baseURL + Endpoints.LIST_CHARACTERS.endpoint() + Utils.authorization()

    private fun onLoad(type: LoadType) {
        val baseUrl: String = this.baseUrl + parameters()
        val request = StringRequest(
            Request.Method.GET,
            baseUrl,
            Response.Listener<String> {
                var list: MutableList<Result> = emptyList<Result>().toMutableList()
                var dados: Characters = Gson().fromJson(it.trim(), Characters::class.java)

                // get total characteres
                TOTAL = dados.data.total

                dados.data?.results?.forEach { list.add(it) }

                when(type) {
                    LoadType.FIRST -> {
                        presenter.updateListRecycler(list)
                        presenter.showProgressBar(false)
                    }
                    LoadType.MORE -> {
                        presenter.paginationRecycler(list)
                        presenter.showLoading(false)
                    }
                }
            },
            Response.ErrorListener {}
        )

        requestQueue.add(request)
    }

    override fun retriveFirstCharacters() {
        requestQueue = Volley.newRequestQueue(presenter.context)
        offset = 0

        presenter.showProgressBar(true)

        onLoad(LoadType.FIRST)
    }

    override fun retriveMoreCharacters() {
        if (offset <= TOTAL) {
            offset += LIMIT

            presenter.showLoading(true)

            Log.d("MORE ITENS", "TOTAL MORE ITENS: " + TOTAL.toString())
            Log.d("MORE ITENS", "OFFSET MORE ITENS: " + offset.toString())

            onLoad(LoadType.MORE)
        }
    }

    private fun parameters() : String = "&orderBy=name&limit=${LIMIT}&offset=${offset}"

    private enum class LoadType { FIRST, MORE }
}