package com.freeworldone.honorpay.ui.base.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders


inline fun <reified T : ViewModel> Fragment.getViewModel(): T = ViewModelProviders.of(this).get(T::class.java)

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> Fragment.getViewModel(crossinline create: () -> T): T = ViewModelProviders.of(this,
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T = create() as T
        }).get(T::class.java)