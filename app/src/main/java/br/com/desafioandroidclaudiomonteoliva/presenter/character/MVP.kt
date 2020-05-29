package br.com.desafioandroidclaudiomonteoliva.presenter.character

import android.content.Context
import android.os.Bundle

import br.com.desafioandroidclaudiomonteoliva.model.gson.character.Result

/**
 * MVP - Character
 */
interface MVP {
    interface Model {
        fun retriveCharacters()
        fun retriveMoreCharacters()
    }

    interface Presenter {
        val context: Context
        val characters: MutableList<Result>
        fun setView(view: View)
        fun showProgressBar(status: Boolean)
        fun showLoading(status: Boolean)
        fun retriveFirstCharacters()
        fun retriveMoreCharacters()
        fun updateListRecycler(list: MutableList<Result>)
        fun paginationRecycler(list: MutableList<Result>)
    }

    interface View {
        companion object {
            val CHARACTER_KEY: String
                get() = "characteres"
        }

        fun showProgressBar(visible: Int)
        fun showLoading(visible: Int)
        fun updateListRecycler()
        fun paginationRecycler()
    }
}