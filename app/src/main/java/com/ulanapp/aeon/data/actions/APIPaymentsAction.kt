package com.ulanapp.aeon.data.actions

import com.ulanapp.aeon.data.responses.PaymentsResponse

interface APIPaymentsAction {

    // метод для получения списка платежей
    suspend fun getPayments(token: String): PaymentsResponse
}