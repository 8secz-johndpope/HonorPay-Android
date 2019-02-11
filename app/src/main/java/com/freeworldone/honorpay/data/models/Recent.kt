package com.freeworldone.honorpay.data.models

import com.squareup.moshi.Json


data class Recent(
        @Json(name = "from_first_name") val fromFirstName: String? = null,
        @Json(name = "honor_id") val honorId: Int = 0,
        @Json(name = "from_type") val fromType: Int = 0,
        @Json(name = "to_type") val toType: Int = 0,
        val message: String? = null,
        @Json(name = "to_honors_received") val toHonorsReceived: Int = 0,
        @Json(name = "from_honors_received") val fromHonorsReceived: Int = 0,
        val authenticode: String? = null,
        val timestamp: Long = 0,
        @Json(name = "from_last_name") val fromLastName: String? = null,
        @Json(name = "to_first_name") val toFirstName: String? = null,
        @Json(name = "user_from") val userFrom: String? = null,
        @Json(name = "to_last_name") val toLastName: String? = null,
        val privacy: Int = 0,
        @Json(name = "user_to") val userTo: Int = 0)