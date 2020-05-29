package br.com.desafioandroidclaudiomonteoliva.model.character

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

class Model(private val presenter: MVP.Presenter):
    MVP.Model {
    private var offset: Int = 0
    private val LIMIT: Int = 20

    override fun retriveCharacters() {
        val requestQueue: RequestQueue = Volley.newRequestQueue(presenter.context)
        val baseUrl: String = Constantes.baseURL + Endpoints.LIST_CHARACTERS.endpoint() + Utils.authorization() + parameters()

        presenter.showProgressBar(true)

        val request = StringRequest(
            Request.Method.GET,
            baseUrl,
            Response.Listener<String> {
                var list: MutableList<Result> = emptyList<Result>().toMutableList()
                var dados: Characters = Gson().fromJson(it.trim(), Characters::class.java)

                dados.data?.results?.forEach { list.add(it) }

                presenter.updateListRecycler(list)
                presenter.showProgressBar(false)
            },
            Response.ErrorListener {}
        )

        requestQueue.add(request)
    }

    private fun parameters() : String = "&orderBy=name&limit=${LIMIT}&offset=${offset}"
}