package com.freeworldone.honorpay.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(indices = [(Index(value = ["user_from", "user_to"]))])
data class Honor(@PrimaryKey
                 val id: Int,
                 val user_from: Int,
                 val user_to: Int,
                 val message: String,
                 val timestamp: Long)