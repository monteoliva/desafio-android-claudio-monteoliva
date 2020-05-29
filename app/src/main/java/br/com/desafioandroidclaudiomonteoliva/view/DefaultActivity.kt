package br.com.desafioandroidclaudiomonteoliva.view

import android.view.KeyEvent

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import br.com.desafioandroidclaudiomonteoliva.utils.UtilsAnimation

abstract class DefaultActivity : AppCompatActivity() {
    private var actionBar: ActionBar? = null
    private var mToolbar: Toolbar? = null

    fun setupToolBar(resource: Int) {
        mToolbar = findViewById(resource)
        setSupportActionBar(mToolbar)
        actionBar = supportActionBar
    }

    fun setActionBarHome()       { actionBar?.setHomeButtonEnabled(true) }
    fun setActionBarHomeButton() { actionBar?.setDisplayHomeAsUpEnabled(true) }

    fun setActionBarNotHome()       { actionBar?.setHomeButtonEnabled(false) }
    fun setActionBarNotHomeButton() { actionBar?.setDisplayHomeAsUpEnabled(false) }

    fun setActionBarTitle(title: String) { actionBar?.title = title }
    fun setActionBarTitle(title: Int)    { actionBar?.title = getString(title) }

    fun setActionBarSubTitle(title: String) { actionBar?.subtitle = title }
    fun setActionBarSubTitle(title: Int)    { actionBar?.subtitle = getString(title) }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            back()
            true
        }
        else {
            super.onKeyDown(keyCode, event)
        }
    }

    /**
     * Method to animate activity Left to Right
     */
    fun animLeftToRight() {
        UtilsAnimation.leftToRight(this)
    }

    /**
     * Method to animate activity Right to Left
     */
    fun animRightToLeft() {
        UtilsAnimation.rightToLeft(this)
    }

    /**
     * Method to animate activity Top to Bottom
     */
    fun animTopToBottom() {
        UtilsAnimation.topToBottom(this)
    }

    /**
     * Method to animate activity Bottom to Top
     */
    fun animBottomToTop() {
        UtilsAnimation.bottomToTop(this)
    }

    /**
     * Method to back old activity or finish application
     */
    abstract fun back()
}