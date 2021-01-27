package br.com.desafioandroidclaudiomonteoliva.presenter.comics

import android.content.Context

import br.com.desafioandroidclaudiomonteoliva.model.contracts.comics.bean.ComicsBean

/**
 * MVP - Comics
 */
interface MVP {
    interface Model {
        fun retriveComics(characterId: Int)
    }

    interface Presenter {
        val context: Context
        fun setView(view: View)
        fun showProgressBar(status: Boolean)
        fun retriveComics(characterId: Int)
        fun updateData(bean: ComicsBean)
    }

    interface View {
        fun showProgressBar(visible: Int)
        fun showTexts(title: String, description: String, price: String)
        fun showComicsImage(imageUrl: String)
        fun showCharacterImage()
    }
}