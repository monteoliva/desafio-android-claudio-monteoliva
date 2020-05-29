package br.com.desafioandroidclaudiomonteoliva.model.gson.comics

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

import br.com.desafioandroidclaudiomonteoliva.model.gson.Events
import br.com.desafioandroidclaudiomonteoliva.model.gson.Thumbnail
import br.com.desafioandroidclaudiomonteoliva.model.gson.Url
import br.com.desafioandroidclaudiomonteoliva.model.gson.Stories

@Parcelize
data class Result(@SerializedName("id")                 @Expose var id: Int,
                  @SerializedName("digitalId")          @Expose var digitalId: Int,
                  @SerializedName("title")              @Expose var title: String,
                  @SerializedName("issueNumber")        @Expose var issueNumber: Int,
                  @SerializedName("variantDescription") @Expose var variantDescription: String,
                  @SerializedName("description")        @Expose var description: String,
                  @SerializedName("modified")           @Expose var modified: String,
                  @SerializedName("isbn")               @Expose var isbn: String,
                  @SerializedName("upc")                @Expose var upc: String,
                  @SerializedName("diamondCode")        @Expose var diamondCode: String,
                  @SerializedName("ean")                @Expose var ean: String,
                  @SerializedName("issn")               @Expose var issn: String,
                  @SerializedName("format")             @Expose var format: String,
                  @SerializedName("pageCount")          @Expose var pageCount: Int,
                  @SerializedName("textObjects")        @Expose var textObjects: List<TextObject>,
                  @SerializedName("resourceURI")        @Expose var resourceURI: String,
                  @SerializedName("urls")               @Expose var urls: List<Url>,
                  @SerializedName("series")             @Expose var series: Series,
                  @SerializedName("variants")           @Expose var variants: List<Variants>,
                  @SerializedName("collections")        @Expose var collections: List<Collections>,
                  @SerializedName("collectedIssues")    @Expose var collectedIssues: List<CollectedIssues>,
                  @SerializedName("dates")              @Expose var dates: List<Date>,
                  @SerializedName("prices")             @Expose var prices: List<Price>,
                  @SerializedName("thumbnail")          @Expose var thumbnail: Thumbnail,
                  @SerializedName("images")             @Expose var images: List<Image>,
                  @SerializedName("creators")           @Expose var creators: Creators,
                  @SerializedName("characters")         @Expose var characters: Characters,
                  @SerializedName("stories")            @Expose var stories: Stories,
                  @SerializedName("events")             @Expose var events: Events
) : Parcelable