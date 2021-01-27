package br.com.desafioandroidclaudiomonteoliva.view.comics

import android.os.Bundle
import android.view.View

import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_comics.*
import kotlinx.android.synthetic.main.app_bar_comics.*

import br.com.desafioandroidclaudiomonteoliva.R
import br.com.desafioandroidclaudiomonteoliva.presenter.comics.Presenter
import br.com.desafioandroidclaudiomonteoliva.presenter.comics.MVP
import br.com.desafioandroidclaudiomonteoliva.view.DefaultActivity

class ComicsActivity : DefaultActivity(R.layout.activity_comics), MVP.View {
    private lateinit var presenter: MVP.Presenter

    private var characterId: Int = 0
    private var characterNa: String = ""
    private var characterUrl: String = ""

    override fun initViews() {
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            characterId  = bundle.getInt("CHARACTER_ID", 0)
            characterNa  = bundle.getString("CHARACTER_NAME", "")
            characterUrl = bundle.getString("CHARACTER_URL", "")
        }

        setupToolBar(R.id.comicsToolbar)
        setActionBarTitle("")
        setActionBarHome()
        setActionBarHomeButton()

        presenter = Presenter()
        presenter.setView(this)
        presenter.retriveComics(characterId)
    }

    override fun initViewModel() {}
    override fun showProgressBar(visible: Int) {
        when(visible) {
            View.VISIBLE -> progressCom.show()
            View.GONE    -> progressCom.hide()
        }
    }

    override fun showTexts(title: String, description: String, price: String) {
        comicsTitle.text = title
        comicsDescription.text = description
        characterName.text = characterNa
        comicsPrice.text = price
    }

    override fun showComicsImage(imageUrl: String) {
        Picasso.get().load(imageUrl).into(comicsImage)
    }

    override fun showCharacterImage() {
        Picasso.get().load(characterUrl).into(characterImg)
    }

    override fun onSupportNavigateUp(): Boolean {
        back()
        return true
    }

    override fun back() { onBackPressed() }
}