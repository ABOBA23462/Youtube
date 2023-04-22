package com.example.youtube.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("key", "AIzaSyAgGgK0s4mU6y8SC2m33bW3ddXKJ8pKBb0").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}