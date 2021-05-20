package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core

import br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core.MicroServiceInterceptor
import okhttp3.OkHttpClient

object OkHttp3 {
    operator fun invoke(interceptor: MicroServiceInterceptor): OkHttpClient{
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .build()
    }
}
