package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.hq

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DateHQ(
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("type")
    val type: String? = null
) : Serializable