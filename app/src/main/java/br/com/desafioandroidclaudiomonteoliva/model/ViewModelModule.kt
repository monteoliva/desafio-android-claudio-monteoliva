package br.com.desafioandroidclaudiomonteoliva.model

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

import br.com.desafioandroidclaudiomonteoliva.view.main.MainViewModel

val viewModelModule = module {
    viewModel { MainViewModel() }
}
