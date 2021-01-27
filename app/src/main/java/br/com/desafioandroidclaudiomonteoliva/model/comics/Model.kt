package br.com.desafioandroidclaudiomonteoliva.model.comics

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import com.google.gson.Gson

import br.com.desafioandroidclaudiomonteoliva.model.enums.Endpoints
import br.com.desafioandroidclaudiomonteoliva.model.contracts.Thumbnail
import br.com.desafioandroidclaudiomonteoliva.model.contracts.comics.Comics
import br.com.desafioandroidclaudiomonteoliva.model.contracts.comics.bean.ComicsBean
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
            {
                val prices: MutableList<ComicsBean> = emptyList<ComicsBean>().toMutableList()
                val dados: Comics = Gson().fromJson(it.trim(), Comics::class.java)

                dados.data.results.forEach { result ->
                    val title: String        = result.title
                    val description: String  = result.description
                    val thumbnail: Thumbnail = result.thumbnail
                    result.prices.forEach { price ->
                        if (price.type == "printPrice" && price.price > 0) {
                            try {
                                prices.add(ComicsBean(title, description, price.price, thumbnail))
                            }
                            catch (ne: KotlinNullPointerException) {}
                        }
                    }
                }

                val imageThumb: Thumbnail = Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available", "jpg")
                val priceOld = ComicsBean("No title","No description", 0.00, imageThumb)

                prices.forEach{ comics ->
                    if (comics.price > priceOld.price) {
                        priceOld.title       = comics.title
                        priceOld.description = comics.description
                        priceOld.price       = comics.price
                        priceOld.thumbnail   = comics.thumbnail
                    }
                }

                presenter.updateData(priceOld)
                presenter.showProgressBar(false)
            },
            {}
        )

        requestQueue.add(request)
    }
}