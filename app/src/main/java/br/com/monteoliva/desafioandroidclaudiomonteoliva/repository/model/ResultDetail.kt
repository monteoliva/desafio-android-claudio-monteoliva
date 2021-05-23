package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.characters.Thumbnail

data class ResultDetail(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("thumbnail")
    var thumbnail: Thumbnail? = null
) : Serializable
