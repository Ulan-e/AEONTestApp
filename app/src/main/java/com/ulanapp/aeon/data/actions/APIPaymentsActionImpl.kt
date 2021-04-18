package com.ulanapp.aeon.data.actions

import com.ulanapp.aeon.data.api.APIFactory
import com.ulanapp.aeon.data.responses.PaymentsResponse
import javax.inject.Inject

class APIPaymentsActionImpl @Inject constructor() : APIPaymentsAction {

    override suspend fun getPayments(token: String): PaymentsResponse {
        return APIFactory.create().getPayments(token)
    }
}