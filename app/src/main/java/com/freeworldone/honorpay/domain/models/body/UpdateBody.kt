package com.freeworldone.honorpay.domain.models.body

data class UpdateBody(
        val auth_token: String,
        val first_name: String? = null,
        val last_name: String? = null,
        val nickname: String? = null,
        val region: String? = null,
        val country: String? = null,
        val attributes: String? = null,
        val email: String? = null,
        val password: String? = null,
        val signature: String? = null,
        val type: Int? = null,
        val notifications: Int? = null,
        val reminders: Int? = null)