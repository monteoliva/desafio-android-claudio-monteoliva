package br.com.desafioandroidclaudiomonteoliva.model.gson

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Thumbnail(@SerializedName("path")      @Expose var path: String? = null,
                     @SerializedName("extension") @Expose var extension: String? = null
) : Parcelable