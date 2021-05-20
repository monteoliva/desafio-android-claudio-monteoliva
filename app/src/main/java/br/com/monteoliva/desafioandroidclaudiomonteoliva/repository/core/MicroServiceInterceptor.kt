package br.com.monteoliva.desafioandroidclaudiomonteoliva.repository.core

import okhttp3.Interceptor
import okhttp3.Response

class MicroServiceInterceptor() : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val requestBuilder = request.newBuilder()
            .header("Cache-Control", "no-cache")

        request = requestBuilder.build()
        return chain.proceed(request)
    }
}
