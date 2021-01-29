package br.com.desafioandroidclaudiomonteoliva.view.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlin.properties.Delegates

import org.koin.androidx.viewmodel.ext.android.viewModel

import br.com.desafioandroidclaudiomonteoliva.R
import br.com.desafioandroidclaudiomonteoliva.model.contracts.character.Result
import br.com.desafioandroidclaudiomonteoliva.presenter.character.MVP
import br.com.desafioandroidclaudiomonteoliva.presenter.character.Presenter
import br.com.desafioandroidclaudiomonteoliva.view.DefaultActivity
import br.com.desafioandroidclaudiomonteoliva.view.detail.DetailActivity
import br.com.desafioandroidclaudiomonteoliva.view.adapter.ItemAdapter
import br.com.desafioandroidclaudiomonteoliva.view.components.Progress
import br.com.desafioandroidclaudiomonteoliva.view.pagination.PaginationListener

class MainActivity : DefaultActivity(R.layout.activity_main), MVP.View {
    private var progress: Progress by Delegates.notNull()
    private var presenter: MVP.Presenter  by Delegates.notNull()
    private var mAdapter: ItemAdapter  by Delegates.notNull()
    private var loading: ProgressBar  by Delegates.notNull()

    private var isLastPage: Boolean = false
    private var isLoading: Boolean = false

    private val viewModel: MainViewModel by viewModel()

    override fun initViews() {
        setupToolBar(R.id.toolbar)
        setActionBarTitle("")

        progress = findViewById(R.id.progress)
        loading  = findViewById(R.id.progressbar)

        presenter = Presenter()
        presenter.setView(this)
        presenter.retriveFirstCharacters()

//        Handler(Looper.getMainLooper()).postDelayed({ onLoad() }, 100)
    }

    override fun initViewModel() {
        viewModel.apply {
            setList(presenter.characters)
            characters.observe(this@MainActivity, { onLoad(it) })
        }
    }

    private fun onLoad(characters: MutableList<Result>) {
        val mLayoutManager = GridLayoutManager(this, 2)

        mAdapter = ItemAdapter(this).apply {
            updateList(characters)
        }

        findViewById<RecyclerView>(R.id.rv).apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            adapter = mAdapter
            addOnScrollListener(object : PaginationListener(mLayoutManager) {
                override fun loadMoreItems() {
                    Log.d("MORE ITENS", "LOAD MORE ITENS")
                    isLoading = true
                    presenter.retriveMoreCharacters()
                }

                override fun isLastPage(): Boolean = isLastPage
                override fun isLoading(): Boolean  = isLoading
            })
        }
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
        mAdapter.notifyDataSetChanged()
    }

    override fun paginationRecycler() {
        isLoading = false
        mAdapter.notifyDataSetChanged()
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