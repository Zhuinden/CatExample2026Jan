package com.zhuinden.catexample2026jan.data.api

import okhttp3.Interceptor
import okhttp3.Response

class CatApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            //.addHeader("x-api-key", "API KEY") // add api key here
            .build()

        val response = chain.proceed(request)

        return response
    }
}