package br.com.desafioandroidclaudiomonteoliva.model.contracts.comics.bean

import android.os.Parcelable
import br.com.desafioandroidclaudiomonteoliva.model.contracts.Thumbnail

import kotlinx.android.parcel.Parcelize

@Parcelize
data class ComicsBean(var title: String,
                      var description: String? = null,
                      var price: Double,
                      var thumbnail: Thumbnail? = null
) : Parcelable