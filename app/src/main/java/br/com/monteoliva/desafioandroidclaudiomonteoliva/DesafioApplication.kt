package br.com.monteoliva.desafioandroidclaudiomonteoliva

import android.app.Application

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.modules.networkModule

class DesafioApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DesafioApplication)
            loadKoinModules(
                listOf(networkModule)
            )
        }
    }
}