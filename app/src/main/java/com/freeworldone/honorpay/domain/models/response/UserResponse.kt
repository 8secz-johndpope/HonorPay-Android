package com.freeworldone.honorpay.domain.models.response

import java.util.*

data class UserResponse(
        val id: Int? = null,
        val first_name: String? = null,
        val last_name: String? = null,
        val nickname: String? = null,
        val region: String? = null,
        val country: String? = null,
        val attributes: String? = null,
        val email: String? = null,
        val signature: String? = null,  //1000 byte text
        val joined: Date? = null,
        val type: Int? = null,
        val public_figure: Int? = null, //1 = yes
        val notifications: Int? = null, //1 = isEmailNotificationsAllowed
        val reminders: Int? = null,     //1 = email weekly email reminders allowed allowed
        val honors_received: Int? = null,
        val total_weight: Int? = null,
        val honors_awards: Int? = null,
        val ghost_creator: String? = null,    //id of creator in the case of ghost account
//        val last_active: Date? = null,
        val last_honoree: Int? = null)     //foreign key, to prevent sequential honoring