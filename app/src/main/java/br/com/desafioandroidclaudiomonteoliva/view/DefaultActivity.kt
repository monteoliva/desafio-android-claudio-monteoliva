package br.com.desafioandroidclaudiomonteoliva.view

import android.os.Bundle
import android.view.KeyEvent
import androidx.annotation.IdRes
import androidx.annotation.StringRes

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import br.com.desafioandroidclaudiomonteoliva.utils.UtilsAnimation

abstract class DefaultActivity(private val resourceId: Int) : AppCompatActivity(resourceId) {
    private var actionBar: ActionBar? = null
    private var mToolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initViewModel()
    }

    fun setupToolBar(@IdRes resource: Int) {
        mToolbar = findViewById(resource)
        setSupportActionBar(mToolbar)
        actionBar = supportActionBar
    }

    fun setActionBarHome()       { actionBar?.setHomeButtonEnabled(true) }
    fun setActionBarHomeButton() { actionBar?.setDisplayHomeAsUpEnabled(true) }

    fun setActionBarNotHome()       { actionBar?.setHomeButtonEnabled(false) }
    fun setActionBarNotHomeButton() { actionBar?.setDisplayHomeAsUpEnabled(false) }

    fun setActionBarTitle(title: String)         { actionBar?.title = title }
    fun setActionBarTitle(@StringRes title: Int) { actionBar?.title = getString(title) }

    fun setActionBarSubTitle(title: String)         { actionBar?.subtitle = title }
    fun setActionBarSubTitle(@StringRes title: Int) { actionBar?.subtitle = getString(title) }

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

    abstract fun back()
    abstract fun initViews()
    abstract fun initViewModel()
}