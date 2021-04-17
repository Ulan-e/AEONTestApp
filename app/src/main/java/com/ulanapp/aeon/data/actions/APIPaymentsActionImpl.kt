package com.ulanapp.aeon.data.actions

import com.ulanapp.aeon.data.api.APIFactory
import com.ulanapp.aeon.data.responses.PaymentsResponse

class APIPaymentsActionImpl: APIPaymentsAction{

    override suspend fun getPayments(token: String) : PaymentsResponse {
        return APIFactory.create().getPayments(token)
    }
}