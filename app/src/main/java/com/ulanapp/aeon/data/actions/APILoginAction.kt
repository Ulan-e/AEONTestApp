package com.ulanapp.aeon.data.actions

import com.ulanapp.aeon.data.responses.LoginResponse


interface APILoginAction {

    // метод для логина
    suspend fun doLogin(login: String, password: String): LoginResponse
}