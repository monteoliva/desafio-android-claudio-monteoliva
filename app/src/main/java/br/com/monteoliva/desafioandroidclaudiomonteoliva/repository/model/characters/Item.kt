package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.characters

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Item(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("type")
    val type: String? = null
) : Serializable