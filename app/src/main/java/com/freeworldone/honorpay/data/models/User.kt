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
                val lastHonoree: Int) : Parcelable {
    constructor(
            id: Int = 0,
            first_name: String = "",
            last_name: String = "",
            nickname: String = "",
            region: String = "",
            country: String = "",
            attributes: String = "",
            email: String = "",
            signature: String = "", //1000 byte text
            joined: Date? = null,
            type: Int = 0,
            public_figure: Int = 0,
            notifications: Int = 0,
            reminders: Int = 0,
            honors_received: Int = 0,
            total_weight: Int = 0,
            honors_awards: Int = 0,
            ghost_creator: Int? = null, //id of creator in the case of ghost account
            last_active: Date? = null,
            last_honoree: Int = 0) // foreign key, to prevent sequential honoring
            : this(
            id = id,
            firstName = first_name,
            lastName = last_name,
            nickname = nickname,
            region = region,
            country = country,
            attributes = attributes,
            email = email,
            signature = signature,
            joined = joined,
            type = UserType.fromInt(type),
            isPublicFigure = public_figure == 1,
            isEmailNotificationsAllowed = notifications == 1,
            isWeeklyEmailRemindersAllowed = reminders == 1,
            honorsReceived = honors_received,
            honorsAwarded = honors_awards,
            lastActive = last_active,
            lastHonoree = last_honoree)
}