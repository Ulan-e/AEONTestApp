package com.ulanapp.aeon.data.api

import retrofit2.Response
import retrofit2.http.*

interface APIService {

    companion object {
        private const val LOGIN = "api-test/login"
        private const val PAYMENTS = "api-test/payments"
    }

    // метод для логина
    @POST(LOGIN)
    @FormUrlEncoded
    suspend fun doLogin(
        @Field("login") login: String,
        @Field("password") password: String,
    ): LoginResponse

    // метод для получения списка платежей
    @GET(PAYMENTS)
    suspend fun getPayments(
        @Query("token") token: String
    ): Response<Any>
}

data class LoginResponse(val success: Boolean, val response: Response) {
    data class Response(val token: String)
}
