package com.example.fixturepractice.Api

import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object FixRetrofitInstance {

    private const val BASE_URL = " https://storage.googleapis.com"

    private fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun setupClient() = OkHttpClient.Builder().addInterceptor(loggingInterceptor()).build()

    private fun initRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(setupClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val fixtureService: FixtureService by lazy {
        initRetrofit().create(fixtureService::class.java)
    }
}