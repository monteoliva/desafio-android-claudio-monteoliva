package br.com.desafioandroidclaudiomonteoliva.model.contracts

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(@SerializedName("resourceURI") @Expose var resourceURI: String? = null,
                @SerializedName("name")        @Expose var name: String? = null,
                @SerializedName("role")        @Expose var role: String? = null,
                @SerializedName("type")        @Expose var type: String? = null
) : Parcelable