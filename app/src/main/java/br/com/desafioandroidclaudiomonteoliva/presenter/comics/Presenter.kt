package br.com.desafioandroidclaudiomonteoliva.presenter.comics

import android.content.Context
import android.view.View

import br.com.desafioandroidclaudiomonteoliva.model.comics.Model
import br.com.desafioandroidclaudiomonteoliva.model.gson.comics.bean.ComicsBean

class Presenter : MVP.Presenter {
    private lateinit var view: MVP.View

    private val model: MVP.Model = Model(this)

    override val context: Context
        get() = view as Context

    override fun setView(view: MVP.View) { this.view = view }
    override fun showProgressBar(status: Boolean) {
        val visible: Int = if (status) View.VISIBLE else View.GONE
        view.showProgressBar(visible)
    }

    override fun retriveComics(characterId: Int) {
        model.retriveComics(characterId)
    }

    override fun updateData(bean: ComicsBean) {
        val description: String? = if (bean.description!!.isEmpty()) "No description" else bean.description
        val title: String = if (bean.title.isEmpty()) "No Title" else bean.title
        val imageUrl = "${bean.thumbnail?.path}.${bean.thumbnail?.extension}"

        view.showTexts(title, description!!, "$ ${bean.price.toString()}")
        view.showComicsImage(imageUrl)
        view.showCharacterImage()
    }
}