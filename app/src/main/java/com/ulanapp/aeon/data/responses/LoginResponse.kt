package com.ulanapp.aeon.data.responses

data class LoginResponse(
    val success: Boolean,
    val response: Token
) {

    data class Token(val token: String)
}