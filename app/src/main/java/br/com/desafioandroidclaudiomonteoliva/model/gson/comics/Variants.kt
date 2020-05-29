package br.com.desafioandroidclaudiomonteoliva.model.gson.comics

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Variants(@SerializedName("none") @Expose var none: String? = null) : Parcelable