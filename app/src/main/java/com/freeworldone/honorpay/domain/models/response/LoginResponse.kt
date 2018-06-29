package com.freeworldone.honorpay.domain.models.response

import java.util.*

//TODO
class LoginResponse(val auth_token: String? = null,
                    val id: Int? = null,
                    val first_name: String? = null,
                    val last_name: String? = null,
                    val nickname: String? = null,
                    val region: String? = null,
                    val country: String? = null,
                    val attributes: String? = null,
                    val email: String? = null,
                    val signature: String? = null,
                    val joined: Date? = null,
                    val type: Int? = null,
                    val public_figure: Int? = null,
                    val notifications: Int? = null,
                    val reminders: Int? = null,
                    val honors_received: Int? = null,
                    val total_weight: Int? = null,
                    val honors_awards: Int? = null,
                    val ghost_creator: Int? = null,
                    val last_active: Date? = null,
                    val last_honoree: Int? = null,
                    val img_url: String? = null,
                    val honors: List<HonorResponse>? = null,
                    val users: List<UserResponse>? = null)