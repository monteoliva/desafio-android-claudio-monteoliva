package br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.hq

import android.os.Bundle
import br.com.monteoliva.desafioandroidclaudiomonteoliva.R

import org.koin.androidx.viewmodel.ext.android.viewModel

import br.com.monteoliva.desafioandroidclaudiomonteoliva.databinding.ActivityHqBinding
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.formatNumber
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.loadImageByGlide
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.visibility
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.hq.Comics
import br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.BaseActivity
import br.com.monteoliva.desafioandroidclaudiomonteoliva.viewmodel.HqViewModel

class HqActivity : BaseActivity() {
    private val hqViewModel: HqViewModel by viewModel()
    private var binding: ActivityHqBinding? = null
    private var characterId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHqBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViews()
        startViewModel()
    }

    override fun initViews() {
        setLoading(true)
        intent?.extras?.let {
            characterId = it.getInt(CHARACTER_ID, 0)
        }
        setupToolBar(R.id.toolbar)
        setActionBarTitle("")
        setActionBarHomeButton()
    }

    override fun initViewModel() {
        hqViewModel.apply {
            getRepository(characterId)
            comicsResult.observe(this@HqActivity, { loadHq(it) })
        }
    }

    private fun loadHq(comics: Comics) {
        val path      = comics.data?.results?.get(0)?.images?.get(0)?.path
        val extension = comics.data?.results?.get(0)?.images?.get(0)?.extension
        val price     = comics.data?.results?.get(0)?.prices?.get(0)?.price

        binding?.apply {
            hqImage.loadImageByGlide(baseContext, "$path.$extension")
            characterHqName.text = comics.data?.results?.get(0)?.title
            descriptionHq.text = comics.data?.results?.get(0)?.description
            priceHq.text = price.formatNumber()
        }





        setLoading(false)
    }

    override fun back() { finish() }
    override fun onSupportNavigateUp(): Boolean {
        back()
        return true
    }

    private fun setLoading(hasVisible: Boolean) { binding?.progressHq?.visibility(hasVisible) }

    companion object {
        const val CHARACTER_ID = "characterId"
    }
}