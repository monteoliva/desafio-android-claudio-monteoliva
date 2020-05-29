package br.com.desafioandroidclaudiomonteoliva.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import br.com.desafioandroidclaudiomonteoliva.R
import br.com.desafioandroidclaudiomonteoliva.presenter.comics.Presenter
import br.com.desafioandroidclaudiomonteoliva.presenter.comics.MVP
import br.com.desafioandroidclaudiomonteoliva.view.components.Progress
import com.squareup.picasso.Picasso

class ComicsActivity : DefaultActivity(), MVP.View {
    private lateinit var presenter: MVP.Presenter
    private lateinit var progress: Progress
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var name: TextView
    private lateinit var price: TextView
    private lateinit var comicsImage: ImageView
    private lateinit var characterImg: ImageView

    private var characterId: Int = 0
    private var characterName: String = ""
    private var characterUrl: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            characterId   = bundle.getInt("CHARACTER_ID", 0)
            characterName = bundle.getString("CHARACTER_NAME", "")
            characterUrl  = bundle.getString("CHARACTER_URL", "")
        }

        setupToolBar(R.id.comicsToolbar)
        setActionBarTitle("")
        setActionBarHome()
        setActionBarHomeButton()

        progress     = findViewById(R.id.progressCom)
        title        = findViewById(R.id.comicsTitle)
        description  = findViewById(R.id.comicsDescription)
        price        = findViewById(R.id.comicsPrice)
        comicsImage  = findViewById(R.id.comicsImage)
        name         = findViewById(R.id.characterName)
        characterImg = findViewById(R.id.characterImg)

        presenter = Presenter()
        presenter.setView(this)
        presenter.retriveComics(characterId)
    }

    override fun showProgressBar(visible: Int) {
        when(visible) {
            View.VISIBLE -> progress.show()
            View.GONE    -> progress.hide()
        }
    }

    override fun showTexts(title: String, description: String, price: String) {
        this.title.text = title
        this.description.text = description
        this.name.text = characterName
        this.price.text = price
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