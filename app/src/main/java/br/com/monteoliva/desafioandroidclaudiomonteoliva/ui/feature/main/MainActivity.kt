package br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.main

import android.os.Bundle

import br.com.monteoliva.desafioandroidclaudiomonteoliva.databinding.ActivityMainBinding
import br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.BaseActivity

class MainActivity : BaseActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViews()
        startViewModel()
    }

    override fun initViews() {
    }

    override fun initViewModel() {
    }

    override fun back() { finish() }
}