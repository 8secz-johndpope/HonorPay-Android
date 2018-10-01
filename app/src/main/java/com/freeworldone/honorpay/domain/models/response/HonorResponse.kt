package com.freeworldone.honorpay.domain.models.response

import java.util.*

data class HonorResponse(
        val id: Int? = null,
        val user_from: Int? = null,
        val user_to: Int? = null,
        val message: String? = null,
        val timestamp: Date? = null)