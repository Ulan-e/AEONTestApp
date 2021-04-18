package com.ulanapp.aeon.data.actions

import com.ulanapp.aeon.data.api.APIFactory
import com.ulanapp.aeon.data.responses.LoginResponse
import javax.inject.Inject

class APILoginActionImpl @Inject constructor() : APILoginAction {

    override suspend fun doLogin(login: String, password: String): LoginResponse {
        return APIFactory.create().doLogin(login, password)
    }
}