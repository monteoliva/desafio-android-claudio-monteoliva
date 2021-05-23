package br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.detail

import android.content.Intent
import android.os.Bundle

import br.com.monteoliva.desafioandroidclaudiomonteoliva.R
import br.com.monteoliva.desafioandroidclaudiomonteoliva.databinding.ActivityDetailBinding
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.loadImageByGlide
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.visibility
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.model.ResultDetail
import br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.BaseActivity
import br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.hq.HqActivity

class DetailActivity : BaseActivity() {
    private var resultDetail: ResultDetail? = null
    private var binding: ActivityDetailBinding? = null
    private var characterId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViews()
        startViewModel()
    }

    override fun initViews() {
        setLoading(true)
        intent?.extras?.let {
            resultDetail = it.getSerializable(RESULT_DETAIL) as ResultDetail
        }
        setupToolBar(R.id.toolbar)
        setActionBarTitle("")
        setActionBarHomeButton()
    }

    override fun initViewModel() {
        val imageUrl = "${resultDetail?.thumbnail?.path}.${resultDetail?.thumbnail?.extension}"
        binding?.let {
            it.detailImage.loadImageByGlide(baseContext, imageUrl)
            it.detailDescription.text = resultDetail?.description
            it.characterName.text     = resultDetail?.name
        }
         resultDetail?.id?.let { characterId = it }
        setLoading(false)
        setButtonListener()
    }

    private fun setButtonListener() {
        if (characterId > 0) {
            binding?.fabDetail?.setOnClickListener {
                Intent(baseContext, HqActivity::class.java).apply {
                    putExtra(HqActivity.CHARACTER_ID, characterId)
                    startActivity(this)
                    animRightToLeft()
                }
            }
        }
        else {
            binding?.fabDetail?.visibility(false)
        }
    }

    private fun setLoading(hasVisible: Boolean) { binding?.progressDetail?.visibility(hasVisible) }

    override fun back() { finish() }
    override fun onSupportNavigateUp(): Boolean {
        back()
        return true
    }

    companion object {
        const val RESULT_DETAIL = "resultDetail"
    }
}