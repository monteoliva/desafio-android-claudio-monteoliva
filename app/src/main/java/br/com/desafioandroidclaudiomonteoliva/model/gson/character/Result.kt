package br.com.desafioandroidclaudiomonteoliva.model.gson.character

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

import br.com.desafioandroidclaudiomonteoliva.model.gson.Events
import br.com.desafioandroidclaudiomonteoliva.model.gson.Stories
import br.com.desafioandroidclaudiomonteoliva.model.gson.Thumbnail
import br.com.desafioandroidclaudiomonteoliva.model.gson.Url

@Parcelize
data class Result(@SerializedName("id")          @Expose var id: Int,
                  @SerializedName("name")        @Expose var name: String,
                  @SerializedName("description") @Expose var description: String,
                  @SerializedName("modified")    @Expose var modified: String,
                  @SerializedName("thumbnail")   @Expose var thumbnail: Thumbnail,
                  @SerializedName("resourceURI") @Expose var resourceURI: String,
                  @SerializedName("comics")      @Expose var comics: Comics,
                  @SerializedName("series")      @Expose var series: Series,
                  @SerializedName("stories")     @Expose var stories: Stories,
                  @SerializedName("events")      @Expose var events: Events,
                  @SerializedName("urls")        @Expose var urls: List<Url>
) : Parcelable