package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.hq

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TextObject(
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("type")
    val type: String? = null
) : Serializable