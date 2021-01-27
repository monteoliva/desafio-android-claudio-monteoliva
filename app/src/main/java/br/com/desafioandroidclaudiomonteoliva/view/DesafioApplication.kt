package br.com.desafioandroidclaudiomonteoliva.view

import android.app.Application

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

import br.com.desafioandroidclaudiomonteoliva.model.viewModelModule

class DesafioApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(applicationContext)
            loadKoinModules(listOf(viewModelModule))
        }
    }
}