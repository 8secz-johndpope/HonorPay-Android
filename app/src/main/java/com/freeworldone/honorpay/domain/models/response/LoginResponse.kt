package com.freeworldone.honorpay.domain.models.response

//TODO
data class LoginResponse(
        val location: String? = null,
        val loginToken: String? = null,
        val type: Int = 0,
        val id: Int = 0,
        val first_name: String? = null,
        val result: String? = null)

//(val auth_token: String? = null,
//                    val id: Int? = null,
//                    val firstName: String? = null,
//                    val lastName: String? = null,
//                    val nickname: String? = null,
//                    val region: String? = null,
//                    val country: String? = null,
//                    val attributes: String? = null,
//                    val email: String? = null,
//                    val signature: String? = null,
//                    val joined: Date? = null,
//                    val type: Int? = null,
//                    val isPublicFigure: Int? = null,
//                    val isEmailNotificationsAllowed: Int? = null,
//                    val isWeeklyEmailRemindersAllowed: Int? = null,
//                    val honorsReceived: Int? = null,
//                    val total_weight: Int? = null,
//                    val honorsAwarded: Int? = null,
//                    val ghost_creator: Int? = null,
//                    val lastActive: Date? = null,
//                    val lastHonoree: Int? = null,
//                    val imgUrl: String? = null,
//                    val honors: List<HonorResponse>? = null,
//                    val users: List<UserResponse>? = null)