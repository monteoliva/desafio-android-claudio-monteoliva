package br.com.desafioandroidclaudiomonteoliva.presenter.detail

import android.content.Context

import br.com.desafioandroidclaudiomonteoliva.model.gson.character.Result

/**
 * MVP - Detail
 */
interface MVP {
    interface Presenter {
        val context: Context
        fun setView(view: View)
        fun updateData(item: Result )
    }

    interface View {
        fun showTexts(name: String, description: String)
        fun showImage(imageUrl: String)
    }
}