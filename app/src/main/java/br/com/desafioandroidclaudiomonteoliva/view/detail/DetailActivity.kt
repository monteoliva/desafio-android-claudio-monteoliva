package br.com.desafioandroidclaudiomonteoliva.view.detail

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

import com.squareup.picasso.Picasso

import br.com.desafioandroidclaudiomonteoliva.R
import br.com.desafioandroidclaudiomonteoliva.model.contracts.character.Result
import br.com.desafioandroidclaudiomonteoliva.presenter.detail.MVP
import br.com.desafioandroidclaudiomonteoliva.presenter.detail.Presenter
import br.com.desafioandroidclaudiomonteoliva.view.DefaultActivity
import br.com.desafioandroidclaudiomonteoliva.view.comics.ComicsActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : DefaultActivity(R.layout.activity_detail), MVP.View {
    private lateinit var presenter: MVP.Presenter
    private lateinit var detailImage: ImageView
    private lateinit var detailName: TextView
    private lateinit var detailDesc: TextView
    private lateinit var detailBtnHQ: FloatingActionButton

    private var item: Result? = null
    private var imageUrl: String = ""

    override fun initViews() {
        intent?.extras?.apply {
            item = getParcelable("ITEM")
        }

        setupToolBar(R.id.detailToolbar)
        setActionBarTitle("")
        setActionBarHome()
        setActionBarHomeButton()

        detailImage = findViewById(R.id.detailImage)
        detailName  = findViewById(R.id.detailName)
        detailDesc  = findViewById(R.id.detailDescription)

        presenter = Presenter()
        presenter.setView(this)
        presenter.updateData(item!!)

        detailBtnHQ = findViewById(R.id.detailBtnHQ)
        detailBtnHQ.setOnClickListener{ goComics() }
    }

    override fun initViewModel() {}
    override fun onSupportNavigateUp(): Boolean {
        back()
        return true
    }

    override fun back() { onBackPressed() }

    private fun goComics() {
        val characterId: Int? = item?.id
        val characterName: String? = item?.name

        val bundle = Bundle()
            bundle.apply {
                putInt("CHARACTER_ID"     , characterId!!)
                putString("CHARACTER_NAME", characterName!!)
                putString("CHARACTER_URL" , imageUrl)
            }

        val intent = Intent(this, ComicsActivity::class.java)
            intent.putExtras(bundle)

        startActivity(intent)
        finish()
        animTopToBottom()
    }

    override fun showTexts(name: String, description: String) {
        detailName.text = name
        detailDesc.text = description
    }

    override fun showImage(imageUrl: String) {
        this.imageUrl = imageUrl
        Picasso.get().load(imageUrl).into(detailImage)
    }
}