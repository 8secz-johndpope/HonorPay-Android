package com.freeworldone.honorpay.ui.base.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment


inline fun <reified T : ViewModel> Fragment.getViewModel(): T = ViewModelProviders.of(this).get(T::class.java)

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> Fragment.getViewModel(crossinline create: () -> T): T = ViewModelProviders.of(this,
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T = create() as T
        }).get(T::class.java)