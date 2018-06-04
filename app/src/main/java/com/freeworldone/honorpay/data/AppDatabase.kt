package com.freeworldone.honorpay.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.freeworldone.honorpay.data.dao.HonorDao
import com.freeworldone.honorpay.data.dao.UserDao
import com.freeworldone.honorpay.data.models.Honor
import com.freeworldone.honorpay.data.models.User

@Database(entities = [Honor::class, User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun honorDao(): HonorDao
    abstract fun userDao(): UserDao
}