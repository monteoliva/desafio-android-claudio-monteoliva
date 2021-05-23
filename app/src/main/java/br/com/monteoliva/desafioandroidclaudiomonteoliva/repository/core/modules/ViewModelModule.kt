package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

import br.com.monteoliva.desafioandroidclaudiomonteoliva.viewmodel.HqViewModel
import br.com.monteoliva.desafioandroidclaudiomonteoliva.viewmodel.MainViewModel

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { HqViewModel(get()) }
}
