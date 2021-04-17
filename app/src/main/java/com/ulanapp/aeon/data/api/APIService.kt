package com.ulanapp.aeon.data.api

import com.ulanapp.aeon.data.responses.LoginResponse
import com.ulanapp.aeon.data.responses.PaymentsResponse
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
    ): PaymentsResponse
}


