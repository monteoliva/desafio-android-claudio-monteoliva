package br.com.desafioandroidclaudiomonteoliva.model.gson.comics

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Date(@SerializedName("type") @Expose var type: String? = null,
                @SerializedName("date") @Expose var date: String? = null
) : Parcelable