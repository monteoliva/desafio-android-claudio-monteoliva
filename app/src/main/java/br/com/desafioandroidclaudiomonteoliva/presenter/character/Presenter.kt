package br.com.desafioandroidclaudiomonteoliva.presenter.character

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.View

import br.com.desafioandroidclaudiomonteoliva.model.character.Model
import br.com.desafioandroidclaudiomonteoliva.model.gson.character.Result

class Presenter : MVP.Presenter {
    private lateinit var view: MVP.View

    private val model: MVP.Model = Model(this)
    private var list: MutableList<Result> = emptyList<Result>().toMutableList()

    override val context: Context
        get() = view as Context
    override val characters: MutableList<Result>
        get() = list

    override fun setView(view: MVP.View) { this.view = view }
    override fun showProgressBar(status: Boolean) {
        val visible: Int = if (status) View.VISIBLE else View.GONE
        view.showProgressBar(visible)
    }

    override fun retriveCharacters(savedInstanceState: Bundle?) {
        if( savedInstanceState != null ) {
            var recipeArray: ArrayList<Parcelable> = savedInstanceState.getParcelableArrayList(
                MVP.View.CHARACTER_KEY)!!
            list = recipeArray as MutableList<Result>
            return;
        }
        model.retriveCharacters()
    }

    override fun updateListRecycler(list: MutableList<Result>) {
        this.list.clear()
        this.list.addAll(list)
        view.updateListRecycler()
    }

    override fun paginationRecycler(list: MutableList<Result>) {
        this.list.addAll(list)
        view.paginationRecycler()
    }
}