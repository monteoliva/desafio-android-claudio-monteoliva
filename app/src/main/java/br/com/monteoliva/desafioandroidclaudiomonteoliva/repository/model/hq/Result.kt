package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.hq

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Result(
    @SerializedName("characters")
    val characters: Characters? = null,
    @SerializedName("collectedIssues")
    val collectedIssues: MutableList<String>? = null,
    @SerializedName("collections")
    val collections: MutableList<String>? = null,
    @SerializedName("creators")
    val creators: Creators? = null,
    @SerializedName("dates")
    val dates: MutableList<DateHQ>? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("diamondCode")
    val diamondCode: String? = null,
    @SerializedName("digitalId")
    val digitalId: Int? = null,
    @SerializedName("ean")
    val ean: String? = null,
    @SerializedName("events")
    val events: Events? = null,
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("images")
    val images: MutableList<Image>? = null,
    @SerializedName("isbn")
    val isbn: String? = null,
    @SerializedName("issn")
    val issn: String? = null,
    @SerializedName("issueNumber")
    val issueNumber: Int? = null,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("pageCount")
    val pageCount: Int? = null,
    @SerializedName("prices")
    val prices: MutableList<Price>? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: Series? = null,
    @SerializedName("stories")
    val stories: Stories? = null,
    @SerializedName("textObjects")
    val textObjects: MutableList<TextObject>? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("upc")
    val upc: String? = null,
    @SerializedName("urls")
    val urls: MutableList<Url>? = null,
    @SerializedName("variantDescription")
    val variantDescription: String? = null,
    @SerializedName("variants")
    val variants: MutableList<Variant>? = null
) : Serializable