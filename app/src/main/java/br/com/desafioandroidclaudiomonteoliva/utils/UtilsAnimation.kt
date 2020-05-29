package br.com.desafioandroidclaudiomonteoliva.utils

import androidx.appcompat.app.AppCompatActivity

import br.com.desafioandroidclaudiomonteoliva.R

/**
 * Classe de Animacao de Activity
 *
 * @author Claudio Monteoliva
 * @version 1.0
 * @copyright 2020 Monteoliva Developer
 */
object UtilsAnimation {
    /**
     * Method to animate activity Left to Right
     */
    fun leftToRight(activity: AppCompatActivity) {
        activity.overridePendingTransition(R.anim.lefttoright, R.anim.stable)
    }

    /**
     * Method to animate activity Right to Left
     */
    fun rightToLeft(activity: AppCompatActivity) {
        activity.overridePendingTransition(R.anim.righttoleft, R.anim.stable)
    }

    /**
     * Method to animate activity Top to Bottom
     */
    fun topToBottom(activity: AppCompatActivity) {
        activity.overridePendingTransition(R.anim.toptobottom, R.anim.stable)
    }

    /**
     * Method to animate activity Bottom to Top
     */
    fun bottomToTop(activity: AppCompatActivity) {
        activity.overridePendingTransition(R.anim.bottomtotop, R.anim.stable)
    }
}