package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.characters

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Url(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null
) : Serializable