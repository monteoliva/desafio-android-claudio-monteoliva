package br.com.desafioandroidclaudiomonteoliva.presenter.detail

import android.content.Context
import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import android.os.Message
import br.com.desafioandroidclaudiomonteoliva.model.gson.character.Result
import br.com.desafioandroidclaudiomonteoliva.presenter.detail.MVP
import br.com.desafioandroidclaudiomonteoliva.view.DefaultActivity
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

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