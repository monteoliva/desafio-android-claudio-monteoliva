package br.com.desafioandroidclaudiomonteoliva.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.desafioandroidclaudiomonteoliva.R
import br.com.desafioandroidclaudiomonteoliva.utils.UtilsAnimation

class SplashScreen : AppCompatActivity() {
    private val seconds: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        load()
    }

    private fun load() {
        Handler().postDelayed({
            var intent: Intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
            finish()
            UtilsAnimation.leftToRight(this)
        }, seconds)

    }
}
