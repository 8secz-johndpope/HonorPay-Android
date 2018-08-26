package com.freeworldone.honorpay.domain.models.response

import java.util.*

class RegisterResponse(
        val auth_token: String? = null,
        val id: Int? = null,
        val next_honor: Date? = null,
        val honors_received: Int? = null,
        val accountStatus: String? = null)