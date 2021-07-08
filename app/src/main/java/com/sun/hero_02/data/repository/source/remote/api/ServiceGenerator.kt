package com.sun.hero_02.data.repository.source.remote.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceGenerator {
    private const val CONNECT_TIMEOUT = 60000L
    private const val READ_TIMEOUT = 60000L
    private const val WRITE_TIMEOUT = 30000L

    fun <T> generate(
        baseUrl: String,
        serviceClass: Class<T>
    ): T {
        val builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildOkHttpClient())
            .build()
        return builder.create(serviceClass)
    }

    private fun buildOkHttpClient() = OkHttpClient.Builder().apply {
        connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
        writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
    }.build()
}
