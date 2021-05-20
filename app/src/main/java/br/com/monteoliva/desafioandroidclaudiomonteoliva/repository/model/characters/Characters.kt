package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.characters

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Characters(
    @SerializedName("attributionHTML")
    val attributionHTML: String? = null,
    @SerializedName("attributionText")
    val attributionText: String? = null,
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("data")
    val data: Data? = null,
    @SerializedName("etag")
    val etag: String? = null,
    @SerializedName("status")
    val status: String? = null
) : Serializable