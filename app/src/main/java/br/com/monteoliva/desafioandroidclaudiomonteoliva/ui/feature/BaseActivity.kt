package br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.feature

import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.bottomToTop
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.leftToRight
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.rightToLeft
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.extensions.topToBottom

abstract class BaseActivity : AppCompatActivity() {
    private var actionBar: ActionBar? = null
    private var mToolbar: Toolbar? = null

    fun startViewModel() {
        Handler(Looper.getMainLooper()).postDelayed({
            initViewModel()
        }, 100)
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

    fun animLeftToRight() { this.leftToRight() }
    fun animRightToLeft() { this.rightToLeft() }
    fun animTopToBottom() { this.topToBottom() }
    fun animBottomToTop() { this.bottomToTop() }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            back()
            true
        }
        else {
            super.onKeyDown(keyCode, event)
        }
    }

    abstract fun initViews()
    abstract fun initViewModel()
    abstract fun back()

    companion object {
        private const val TAG = "BaseActivity"
    }
}