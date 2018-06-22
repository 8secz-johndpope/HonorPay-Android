package com.freeworldone.honorpay.data

import android.arch.persistence.room.Room
import com.freeworldone.honorpay.appContext

object DatabaseManager {
    val db: AppDatabase = Room.databaseBuilder(appContext, AppDatabase::class.java, "HonorPay").fallbackToDestructiveMigration().build()
}