package com.example.youtube.data.remote

import com.example.youtube.constant.Constant
import com.example.youtube.data.remote.apiservice.VideoApiService
import com.example.youtube.data.remote.interceptors.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {
    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(ApiKeyInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/youtube/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideVideoApiService(): VideoApiService =
        retrofitClient.create(VideoApiService::class.java)
}