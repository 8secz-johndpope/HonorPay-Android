package com.freeworldone.honorpay.data.models

import com.squareup.moshi.Json
import java.util.*

data class Award(
        @Json(name = "next_honor") val nextHonor: Date? = null,
        @Json(name = "honor_id") val honorId: Int = 0)