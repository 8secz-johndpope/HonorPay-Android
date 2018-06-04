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
                val signature: String,
                val joined: Long?,
                val type: Int,
                val public_figure: Boolean,
                val notifications: Boolean,
                val reminders: Boolean,
                val honors_received: Int,
                val total_weight: Int,
                val honors_awards: Int,
                val ghost_creator: Int?,
                val last_active: Long?,
                val last_honoree: Int,
                val honorpie: Float)