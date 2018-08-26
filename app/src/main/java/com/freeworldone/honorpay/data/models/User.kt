package com.freeworldone.honorpay.data.models

import android.os.Parcelable
import com.freeworldone.honorpay.data.enums.UserType
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class User(val id: Int,
                val firstName: String,
                val lastName: String,
                val nickname: String,
                val region: String,
                val country: String,
                val attributes: String,
                val email: String,
                val signature: String,
                val joined: Date?,
                val type: UserType,
                val isPublicFigure: Boolean,
                val isEmailNotificationsAllowed: Boolean,
                val isWeeklyEmailRemindersAllowed: Boolean,
                val honorsReceived: Int,
                val honorsAwarded: Int,
                val lastActive: Date?,
                val lastHonoree: Int): Parcelable