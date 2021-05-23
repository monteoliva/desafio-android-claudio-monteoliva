package br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat

import br.com.monteoliva.desafioandroidclaudiomonteoliva.R
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.gone
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.visible

class Progress(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    init {
        initViews()
    }

    private fun initViews() {
        context?.let {
            setBackgroundColor(ContextCompat.getColor(it, android.R.color.transparent))
            LayoutInflater.from(it).inflate(R.layout.progress, this)
        }
    }

    fun show() { this.visible() }
    fun hide() { this.gone()    }
}