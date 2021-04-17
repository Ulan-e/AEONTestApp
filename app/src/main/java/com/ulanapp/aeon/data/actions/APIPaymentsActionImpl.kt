package com.ulanapp.aeon.data.actions

import com.ulanapp.aeon.data.api.APIFactory
import retrofit2.Response

class APIPaymentsActionImpl: APIPaymentsAction{

    override suspend fun getPayments(token: String) : Response<Any> {
        return APIFactory.create().getPayments(token)
    }
}