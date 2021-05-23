package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.modules

import org.koin.dsl.module

import br.com.monteoliva.desafioandroidclaudiomonteoliva.ui.adapter.CharactersAdapter

var adapterModule = module {
    factory { CharactersAdapter() }
}