package br.com.desafioandroidclaudiomonteoliva.model.contracts.comics

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Series(@SerializedName("resourceURI") @Expose var resourceURI: String? = null,
                  @SerializedName("name")        @Expose var name: String? = null
) : Parcelable