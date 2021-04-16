package com.ulanapp.aeon.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIFactory {

    private const val BASE_URL = "http://82.202.204.94/"

    fun create(): APIService {

        val httpclient = OkHttpClient.Builder()
        httpclient.addInterceptor(Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("app-key", "12345")
                .addHeader("v", "1")
                .build()
            chain.proceed(request)
        })

        val retrofit = Retrofit.Builder()
            .client(httpclient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(APIService::class.java);
    }
}