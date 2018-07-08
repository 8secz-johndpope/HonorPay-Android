package com.freeworldone.honorpay.ui.base.extensions

import android.content.Context
import android.content.SharedPreferences

val Context.prefs: SharedPreferences get() = getSharedPreferences("HonorPay", 0)