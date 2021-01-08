package br.com.desafioandroidclaudiomonteoliva.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ProgressBar

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import br.com.desafioandroidclaudiomonteoliva.R
import br.com.desafioandroidclaudiomonteoliva.model.gson.character.Result
import br.com.desafioandroidclaudiomonteoliva.presenter.character.MVP
import br.com.desafioandroidclaudiomonteoliva.presenter.character.Presenter
import br.com.desafioandroidclaudiomonteoliva.view.adapter.ItemAdapter
import br.com.desafioandroidclaudiomonteoliva.view.components.Progress
import br.com.desafioandroidclaudiomonteoliva.view.pagination.PaginationListener

class MainActivity : DefaultActivity(R.layout.activity_main), MVP.View {
    private lateinit var progress: Progress
    private lateinit var rv: RecyclerView
    private lateinit var presenter: MVP.Presenter
    private lateinit var adapter: ItemAdapter
    private lateinit var loading: ProgressBar

    private var isLastPage: Boolean = false
    private var isLoading: Boolean = false

    override fun initViews() {
        setupToolBar(R.id.toolbar)
        setActionBarTitle("")

        progress = findViewById(R.id.progress)
        loading  = findViewById(R.id.progressbar)

        presenter = Presenter()
        presenter.setView(this)
        presenter.retriveFirstCharacters()

        Handler().postDelayed({ onLoad() }, 100)
    }

    override fun initViewModel() {}

    private fun onLoad() {
        val layoutManager = GridLayoutManager(this, 2)

        adapter = ItemAdapter(this, presenter.characters)

        rv = findViewById(R.id.rv)
        rv.setHasFixedSize(true)
        rv.layoutManager = layoutManager
        rv.adapter = adapter
        rv.addOnScrollListener(object : PaginationListener(layoutManager) {
            override fun loadMoreItems() {
                Log.d("MORE ITENS", "LOAD MORE ITENS")
                isLoading = true
                presenter.retriveMoreCharacters()
            }

            override fun isLastPage(): Boolean = isLastPage
            override fun isLoading(): Boolean  = isLoading
        })
    }

    override fun back() { finish() }
    override fun showProgressBar(visible: Int) {
        when(visible) {
            View.VISIBLE -> progress.show()
            View.GONE    -> progress.hide()
        }
    }

    override fun showLoading(visible: Int) {
        loading.visibility = visible
    }

    override fun updateListRecycler() {
        adapter.notifyDataSetChanged()
    }

    override fun paginationRecycler() {
        isLoading = false
        adapter.notifyDataSetChanged()
    }

    fun detail(item: Result) {
        val bundle = Bundle()
            bundle.putParcelable("ITEM", item)

        Intent(this, DetailActivity::class.java).apply {
            putExtras(bundle)
            startActivity(this)
        }

        animBottomToTop()
    }
}