package com.ulanapp.aeon.data.actions

import retrofit2.Response

interface APIPaymentsAction {

    suspend fun getPayments(token: String): Response<Any>
}