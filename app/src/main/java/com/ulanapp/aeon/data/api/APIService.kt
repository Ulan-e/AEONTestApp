package com.ulanapp.aeon.data.api

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface APIService {

    companion object {
        private const val LOGIN = "api-test/login"
        private const val PAYMENTS = "api-test/payments"
    }

    @POST(LOGIN)
    @FormUrlEncoded
    suspend fun doLogin(
        @Field("login") login: String,
        @Field("password") password: String,
    ): Response<Any>

    @GET(PAYMENTS)
    suspend fun getPayments(
        @Query("token") token: String
    ): Response<Any>
}