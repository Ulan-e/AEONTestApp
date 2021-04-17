package com.ulanapp.aeon.data.actions

import com.ulanapp.aeon.data.api.LoginResponse

interface APILoginAction {

    suspend fun doLogin(login: String, password: String): LoginResponse
}