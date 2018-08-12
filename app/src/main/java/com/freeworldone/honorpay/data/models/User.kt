package com.freeworldone.honorpay.data.models

import android.os.Parcelable
import com.freeworldone.honorpay.data.enums.UserType
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class User(val id: Int,
                val first_name: String,
                val last_name: String,
                val nickname: String,
                val region: String,
                val country: String,
                val attributes: String,
                val email: String,
                val signature: String,      //1000 byte text
                val img_url: String?,
                val joined: Date?,
                val type: UserType,
                val public_figure: Boolean, //1 = yes
                val notifications: Boolean, //1 = email notifications allowed
                val reminders: Boolean,     //1 = email weekly reminders allowed
                val honors_received: Int,
                val honors_awards: Int,
//                val ghost_creator: Int?,    //id of creator in the case of ghost account
                val last_active: Date?,
                val last_honoree: Int): Parcelable      //foreign key, to prevent sequential honoring