package com.freeworldone.honorpay.domain.models.body

data class AwardBody(
        val auth_token: String,
        val user_from: Int,
        val user_to: Int)