package com.freeworldone.honorpay.ui.base.extensions

import android.util.Log

fun Any.log(message: String) {
    Log.d(javaClass.simpleName, message)
}