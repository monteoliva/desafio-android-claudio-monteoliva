package br.com.desafioandroidclaudiomonteoliva.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import br.com.desafioandroidclaudiomonteoliva.R
import br.com.desafioandroidclaudiomonteoliva.utils.leftToRight
import br.com.desafioandroidclaudiomonteoliva.view.main.MainActivity

class SplashScreen : AppCompatActivity() {
    private val seconds: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        load()
    }

    private fun load() {
        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
                finish()
                this@SplashScreen.leftToRight()
            }
        }, seconds)

    }
}
