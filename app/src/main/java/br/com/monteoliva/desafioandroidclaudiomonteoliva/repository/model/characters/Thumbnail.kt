package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.characters

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Thumbnail(
    @SerializedName("extension")
    val extension: String? = null,
    @SerializedName("path")
    val path: String? = null
) : Serializable