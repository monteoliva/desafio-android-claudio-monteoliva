package br.com.desafioandroidclaudiomonteoliva.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import android.view.View

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import br.com.desafioandroidclaudiomonteoliva.R
import br.com.desafioandroidclaudiomonteoliva.model.gson.character.Result
import br.com.desafioandroidclaudiomonteoliva.presenter.character.MVP
import br.com.desafioandroidclaudiomonteoliva.presenter.character.Presenter
import br.com.desafioandroidclaudiomonteoliva.view.adapter.ItemAdapter
import br.com.desafioandroidclaudiomonteoliva.view.components.Progress

class MainActivity : DefaultActivity(), MVP.View {
    private lateinit var progress: Progress
    private lateinit var rv: RecyclerView
    private lateinit var presenter: MVP.Presenter
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolBar(R.id.toolbar)
        setActionBarTitle("")

        progress = findViewById(R.id.progress)

        presenter = Presenter()
        presenter.setView(this)
        presenter.retriveCharacters(savedInstanceState)

        Handler().postDelayed({ onLoad() }, 100)
    }

    private fun onLoad() {
        val layoutManager = GridLayoutManager(this, 2)

        adapter = ItemAdapter(this, presenter.characters)

        rv = findViewById(R.id.rv)
        rv.setHasFixedSize(true)
        rv.layoutManager = layoutManager
        rv.adapter = adapter
    }

    override fun back() { finish() }
    override fun showProgressBar(visible: Int) {
        when(visible) {
            View.VISIBLE -> progress.show()
            View.GONE    -> progress.hide()
        }
    }

    override fun updateListRecycler() {
        adapter.notifyDataSetChanged()
    }

    override fun paginationRecycler() {
        adapter.notifyDataSetChanged()
    }

    fun detail(item: Result) {
        var bundle = Bundle()
            bundle.putParcelable("ITEM", item)

        var intent = Intent(this, DetailActivity::class.java)
            intent.putExtras(bundle)

        startActivity(intent)
        animBottomToTop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(MVP.View.CHARACTER_KEY, ArrayList<Parcelable>(presenter.characters))
        super.onSaveInstanceState(outState)
    }
}