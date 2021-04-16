package com.ulanapp.aeon.data.actions

import com.ulanapp.aeon.data.api.APIFactory
import retrofit2.Response

class APILoginActionImpl : APILoginAction {

    override suspend fun doLogin(login: String, password: String): Response<Any> {
        return APIFactory.create().doLogin("demo", "12345")
    }
}