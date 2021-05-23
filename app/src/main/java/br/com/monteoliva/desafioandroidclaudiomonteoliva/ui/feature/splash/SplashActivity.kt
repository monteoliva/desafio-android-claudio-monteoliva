package br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import br.com.monteoliva.desafioandroidclaudiomonteoliva.databinding.ActivitySplashBinding
import br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.BaseActivity
import br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature.main.MainActivity

class SplashActivity : BaseActivity() {
    private var binding: ActivitySplashBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViews()
        startViewModel()
    }

    override fun initViews() {
        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
                finish()
                animRightToLeft()
            }
        }, TIME_LOAD)
    }

    override fun initViewModel() {}
    override fun back() { finishAffinity() }

    companion object {
        private const val TIME_LOAD: Long = 3 * 1000
    }
}