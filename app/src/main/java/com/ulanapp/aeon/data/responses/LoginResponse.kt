package com.ulanapp.aeon.data.responses

data class LoginResponse(val success: Boolean, val response: Response) {

    data class Response(val token: String)
}