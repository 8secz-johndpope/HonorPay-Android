package com.freeworldone.honorpay.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class User(@PrimaryKey
                val id: Int,
                val first_name: String,
                val last_name: String,
                val nickname: String,
                val region: String,
                val country: String,
                val attributes: String,
                val email: String,
                val signature: String, //1000 byte text
                val img_url: String?,
                val joined: Long?,
                val type: Int, //2 = confirmed, 1 = unconfirmed, 0 = ghost, -1 = in memoriam
                val public_figure: Boolean, //1 = yes
                val notifications: Boolean, //1 = email notifications allowed
                val reminders: Boolean, //1 = email weekly reminders allowed
                val honors_received: Int,
                val total_weight: Int, //incremented with awarder's score. Recorded but not used
                val honors_awards: Int,
                val ghost_creator: Int?, //id of creator in the case of ghost account
                val last_active: Long?,
                val last_honoree: Int) //foreign key, to prevent sequential honoring