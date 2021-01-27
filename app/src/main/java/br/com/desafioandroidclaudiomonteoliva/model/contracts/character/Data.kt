package br.com.desafioandroidclaudiomonteoliva.model.contracts.character

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(@SerializedName("offset")  @Expose var offset: Int,
                @SerializedName("limit")   @Expose var limit: Int,
                @SerializedName("total")   @Expose var total: Int,
                @SerializedName("count")   @Expose var count: Int,
                @SerializedName("results") @Expose var results: List<Result>? = null
) : Parcelable