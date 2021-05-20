package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions

import androidx.fragment.app.FragmentActivity

import br.com.monteoliva.desafioandroidclaudiomonteoliva.R

fun FragmentActivity.leftToRight() {
    overridePendingTransition(R.anim.lefttoright, R.anim.stable)
}

fun FragmentActivity.rightToLeft() {
    overridePendingTransition(R.anim.righttoleft, R.anim.stable)
}

fun FragmentActivity.topToBottom() {
    overridePendingTransition(R.anim.toptobottom, R.anim.stable)
}

fun FragmentActivity.bottomToTop() {
    overridePendingTransition(R.anim.bottomtotop, R.anim.stable)
}