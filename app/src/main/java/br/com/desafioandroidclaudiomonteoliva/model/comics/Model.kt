package br.com.desafioandroidclaudiomonteoliva.model.comics

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import com.google.gson.Gson

import br.com.desafioandroidclaudiomonteoliva.model.enums.Endpoints
import br.com.desafioandroidclaudiomonteoliva.model.gson.Thumbnail
import br.com.desafioandroidclaudiomonteoliva.model.gson.comics.Comics
import br.com.desafioandroidclaudiomonteoliva.model.gson.comics.bean.ComicsBean
import br.com.desafioandroidclaudiomonteoliva.presenter.comics.MVP
import br.com.desafioandroidclaudiomonteoliva.utils.Constantes
import br.com.desafioandroidclaudiomonteoliva.utils.Utils
import java.text.MessageFormat

class Model(private val presenter: MVP.Presenter): MVP.Model {
    override fun retriveComics(characterId: Int) {
        val requestQueue: RequestQueue = Volley.newRequestQueue(presenter.context)
        val wsEndpoint: String = Endpoints.HQ_CHARACTERS.endpoint()
        val uri: String = MessageFormat.format(wsEndpoint, characterId.toString())
        val baseUrl: String = Constantes.baseURL + uri + Utils.authorization()

        presenter.showProgressBar(true)

        val request = StringRequest(
            Request.Method.GET,
            baseUrl,
            Response.Listener<String> {
                var prices: MutableList<ComicsBean> = emptyList<ComicsBean>().toMutableList()
                var dados: Comics = Gson().fromJson(it.trim(), Comics::class.java)

                dados.data.results.forEach {
                    var title: String        = it.title
                    var description: String  = it.description
                    var thumbnail: Thumbnail = it.thumbnail
                    it.prices.forEach {
                        if (it.type.equals("printPrice") && it.price > 0) {
                            try {
                                prices.add(ComicsBean(title, description, it.price, thumbnail))
                            }
                            catch (ne: KotlinNullPointerException) {}
                        }
                    }
                }

                var imageThumb: Thumbnail = Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available", "jpg")
                var priceOld = ComicsBean("No title","No description", 0.00, imageThumb)

                prices.forEach{
                    if (it.price > priceOld.price) {
                        priceOld.title       = it.title
                        priceOld.description = it.description
                        priceOld.price       = it.price
                        priceOld.thumbnail   = it.thumbnail
                    }
                }

                presenter.updateData(priceOld)
                presenter.showProgressBar(false)
            },
            Response.ErrorListener {}
        )

        requestQueue.add(request)
    }
}