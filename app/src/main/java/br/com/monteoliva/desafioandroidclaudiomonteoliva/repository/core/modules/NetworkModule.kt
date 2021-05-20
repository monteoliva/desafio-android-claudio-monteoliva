package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.modules

import org.koin.dsl.module

import retrofit2.Retrofit

import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.api.ApiService
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.MicroServiceInterceptor
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.OkHttp3
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.RepositoryServer
import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.RetrofitMobile

var networkModule = module {
    single { RetrofitMobile(get()) }
    single {(get() as Retrofit).create(ApiService::class.java) }

    factory { OkHttp3(get()) }
    factory { MicroServiceInterceptor() }
    factory { RepositoryServer(get()) }
}