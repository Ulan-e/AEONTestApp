package com.ulanapp.aeon.data.actions

import retrofit2.Response

interface APILoginAction {

    suspend fun doLogin(login: String, password: String): Response<Any>
}