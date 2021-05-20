package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.hq

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Image(
    @SerializedName("extension")
    val extension: String? = null,
    @SerializedName("path")
    val path: String? = null
) : Serializable