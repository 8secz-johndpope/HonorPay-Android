package com.freeworldone.honorpay.ui.base.extensions

import android.content.SharedPreferences
import com.freeworldone.honorpay.appContext

const val SAVED_USER_ID = "SAVED_USER_ID"

val prefs: SharedPreferences get() = appContext.getSharedPreferences("HonorPay", 0)