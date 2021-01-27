package br.com.desafioandroidclaudiomonteoliva.presenter.detail

import android.content.Context
import br.com.desafioandroidclaudiomonteoliva.model.contracts.character.Result

class Presenter : MVP.Presenter {
    private lateinit var view: MVP.View

    override val context: Context
        get() = view as Context

    override fun setView(view: MVP.View) { this.view = view }
    override fun updateData(item: Result) {
        val description: String = if (item.description.trim().isEmpty()) "No description" else item.description
        val imageUrl = "${item.thumbnail.path}.${item.thumbnail?.extension}"

        view.showTexts(item.name, description)
        view.showImage(imageUrl)
    }
}