package br.com.desafioandroidclaudiomonteoliva.view

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

import com.squareup.picasso.Picasso

import br.com.desafioandroidclaudiomonteoliva.R
import br.com.desafioandroidclaudiomonteoliva.model.gson.character.Result
import br.com.desafioandroidclaudiomonteoliva.presenter.detail.MVP
import br.com.desafioandroidclaudiomonteoliva.presenter.detail.Presenter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : DefaultActivity(), MVP.View {
    private lateinit var presenter: MVP.Presenter
    private lateinit var detailImage: ImageView
    private lateinit var detailName: TextView
    private lateinit var detailDesc: TextView
    private lateinit var detailBtnHQ: FloatingActionButton

    private var item: Result? = null
    private var imageUrl: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            item = bundle.getParcelable("ITEM")
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
    }

    override fun onStart() {
        super.onStart()

        // FloatingActionButton
        detailBtnHQ = findViewById(R.id.detailBtnHQ)
        detailBtnHQ.setOnClickListener{ goComics() }
    }

    override fun onSupportNavigateUp(): Boolean {
        back()
        return true
    }

    override fun back() { onBackPressed() }

    private fun goComics() {
        var characterId: Int? = item?.id
        var characterName: String? = item?.name

        val bundle = Bundle()
            bundle.putInt("CHARACTER_ID"     , characterId!!)
            bundle.putString("CHARACTER_NAME", characterName!!)
            bundle.putString("CHARACTER_URL" , imageUrl)

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