package br.com.desafioandroidclaudiomonteoliva.model.contracts.comics

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class CollectedIssues(@SerializedName("none") @Expose var none: String? = null) : Parcelable