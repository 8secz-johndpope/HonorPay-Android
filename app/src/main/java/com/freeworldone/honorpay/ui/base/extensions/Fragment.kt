package com.freeworldone.honorpay.ui.base.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment


inline fun <reified T : ViewModel> Fragment.getViewModel(): T = ViewModelProviders.of(this).get(T::class.java)