package com.freeworldone.honorpay.data

import android.arch.persistence.room.Room
import com.freeworldone.honorpay.App

object DatabaseManager {
    val db: AppDatabase = Room.databaseBuilder(App.context, AppDatabase::class.java, "HonorPay").fallbackToDestructiveMigration().build()
}