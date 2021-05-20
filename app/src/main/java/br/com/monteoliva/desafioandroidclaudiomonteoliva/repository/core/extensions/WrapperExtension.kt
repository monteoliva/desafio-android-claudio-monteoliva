package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.characters.Characters
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.hq.Comics

fun Call<Characters>.charactersWrapper(callback: (Characters) -> Unit) {
    this.apply {
        enqueue(object : Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.isSuccessful) { response.body()?.let { callback.invoke(it) }}
                else {
                    response.errorBody()?.let {
                        Gson().fromJson(it.string(), Characters::class.java).apply { callback.invoke(this) }
                    }
                }
            }
            override fun onFailure(call: Call<Characters>, t: Throwable) {}
        })
    }
}

fun Call<Comics>.comicsWrapper(callback: (Comics) -> Unit) {
    this.apply {
        enqueue(object : Callback<Comics> {
            override fun onResponse(call: Call<Comics>, response: Response<Comics>) {
                if (response.isSuccessful) { response.body()?.let { callback.invoke(it) }}
                else {
                    response.errorBody()?.let {
                        Gson().fromJson(it.string(), Comics::class.java).apply { callback.invoke(this) }
                    }
                }
            }
            override fun onFailure(call: Call<Comics>, t: Throwable) {}
        })
    }
}
