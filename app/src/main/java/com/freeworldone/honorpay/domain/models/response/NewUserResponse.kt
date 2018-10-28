package com.freeworldone.honorpay.domain.models.response

data class NewUserResponse(
        val id: Int? = null,
        val result: String? = null,
        val message: String? = null,
        val field: String? = null,
        val error: String? = null)