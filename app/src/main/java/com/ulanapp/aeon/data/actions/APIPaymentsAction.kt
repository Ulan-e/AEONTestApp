package com.ulanapp.aeon.data.actions

interface APIPaymentsAction {

    suspend fun getPayments(token: String): Any
}