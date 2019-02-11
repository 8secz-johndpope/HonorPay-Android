package com.freeworldone.honorpay.api.models.body

data class AwardBody(
        val auth_token: String,
        val user_from: Int,
        val user_to: Int)