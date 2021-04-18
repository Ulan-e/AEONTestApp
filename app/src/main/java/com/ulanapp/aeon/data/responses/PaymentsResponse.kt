package com.ulanapp.aeon.data.responses

data class PaymentsResponse(
    val success: Boolean,
    val response: List<Response>
) {

    data class Response(
        val desc: String,
        val amount: Double,
        val currency: String?,
        val created: Long,
    )
}