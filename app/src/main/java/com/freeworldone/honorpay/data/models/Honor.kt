package com.freeworldone.honorpay.data.models


import com.squareup.moshi.Json
import java.util.*

data class Honor(
        val id: Int = 0,
        @Json(name = "user_from") val userFrom: Int = 0,
        @Json(name = "user_to") val userTo: Int = 0,
        val message: String? = null, //1000 byte text
        val timestamp: Date? = null)