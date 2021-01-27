package br.com.desafioandroidclaudiomonteoliva.model.contracts.comics

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

import br.com.desafioandroidclaudiomonteoliva.model.contracts.Item

@Parcelize
data class Characters(@SerializedName("available")     @Expose var available: Int? = null,
                      @SerializedName("collectionURI") @Expose var collectionURI: String? = null,
                      @SerializedName("items")         @Expose var items: List<Item>? = null,
                      @SerializedName("returned")      @Expose var returned: Int? = null
) : Parcelable