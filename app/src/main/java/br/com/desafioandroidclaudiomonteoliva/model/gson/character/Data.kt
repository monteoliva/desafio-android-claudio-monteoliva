package br.com.desafioandroidclaudiomonteoliva.model.gson.character

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(@SerializedName("offset")  @Expose var offset: Int? = null,
                @SerializedName("limit")   @Expose var limit: Int? = null,
                @SerializedName("total")   @Expose var total: Int? = null,
                @SerializedName("count")   @Expose var count: Int? = null,
                @SerializedName("results") @Expose var results: List<Result>? = null
) : Parcelable