package br.com.desafioandroidclaudiomonteoliva.model.contracts.character

import android.os.Parcelable
import br.com.desafioandroidclaudiomonteoliva.model.contracts.Item

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Series(@SerializedName("available")     @Expose var available: Int? = null,
                  @SerializedName("collectionURI") @Expose var collectionURI: String? = null,
                  @SerializedName("items")         @Expose var items: List<Item>? = null,
                  @SerializedName("returned")      @Expose var returned: Int? = null
) : Parcelable