package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.hq

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Price(
    @SerializedName("price")
    val price: Double? = null,
    @SerializedName("type")
    val type: String? = null
) : Serializable