package com.ulanapp.aeon.data.actions

import com.ulanapp.aeon.data.responses.PaymentsResponse

interface APIPaymentsAction {

    suspend fun getPayments(token: String): PaymentsResponse
}