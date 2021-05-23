package br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager

import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

import br.com.monteoliva.desafioandroidclaudiomonteoliva.databinding.ActivityMainBinding
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.visibility
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.characters.Characters
import br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.adapter.CharactersAdapter
import br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.BaseActivity
import br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.detail.DetailActivity
import br.com.monteoliva.desafioandroidclaudiomonteoliva.viewmodel.MainViewModel

class MainActivity : BaseActivity() {
    private val itemAdapter: CharactersAdapter by inject()
    private val mainViewModel: MainViewModel by viewModel()
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViews()
        startViewModel()
    }

    override fun initViews() {
        setLoading(true)
    }

    override fun initViewModel() {
        mainViewModel.apply {
            getRepository()
            listResult.observe(this@MainActivity, { loadItems(it) })
        }
    }

    private fun loadItems(characters: Characters) {
        itemAdapter.apply {
            onClick = { resultDetail ->
                Intent(baseContext, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.RESULT_DETAIL, resultDetail)
                    startActivity(this)
                    animRightToLeft()
                }
            }
            characters.data?.results?.let { updateList(it) }
        }

        binding?.rvCharacters?.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(baseContext, 2)
            adapter = itemAdapter
        }

        setLoading(false)
    }

    private fun setLoading(hasVisible: Boolean) { binding?.progressCharacter?.visibility(hasVisible) }

    override fun back() { finish() }
}