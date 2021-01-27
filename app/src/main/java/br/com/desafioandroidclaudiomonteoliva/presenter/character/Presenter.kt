package br.com.desafioandroidclaudiomonteoliva.presenter.character

import android.content.Context
import android.view.View

import br.com.desafioandroidclaudiomonteoliva.model.character.Model
import br.com.desafioandroidclaudiomonteoliva.model.contracts.character.Result

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

    override fun showLoading(status: Boolean) {
        val visible: Int = if (status) View.VISIBLE else View.INVISIBLE
        view.showLoading(visible)
    }

    override fun retriveFirstCharacters() {
        model.retriveFirstCharacters()
    }

    override fun retriveMoreCharacters() {
        model.retriveMoreCharacters()
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