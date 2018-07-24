package com.freeworldone.honorpay.domain.models.response

data class RecentResponse(
        val from_first_name: String? = null,
        val honor_id: String? = null,
        val from_type: Int? = null,
        val to_type: Int? = null,
        val message: String? = null,
        val to_honors_received: Int? = null,
        val from_honors_received: Int? = null,
        val authenticode: String? = null,
        val timestamp: Long? = null,
        val from_last_name: String? = null,
        val to_first_name: String? = null,
        val user_from: String? = null,
        val to_last_name: String? = null,
        val privacy: Int? = null,
        val user_to: Int? = null
)