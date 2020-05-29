package br.com.desafioandroidclaudiomonteoliva.model.gson.comics

import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comics(@SerializedName("code")            @Expose var code: Int,
                  @SerializedName("status")          @Expose var status: String,
                  @SerializedName("copyright")       @Expose var copyright: String,
                  @SerializedName("attributionText") @Expose var attributionText: String,
                  @SerializedName("attributionHTML") @Expose var attributionHTML: String,
                  @SerializedName("etag")            @Expose var etag: String,
                  @SerializedName("data")            @Expose var data: Data
) : Parcelable