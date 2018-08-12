package com.freeworldone.honorpay.ui

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.freeworldone.honorpay.data.models.User
import com.freeworldone.honorpay.ui.base.extensions.prefs
import com.freeworldone.honorpay.ui.base.extensions.user

class MainViewModel : ViewModel() {
    val appBarExpanded: ObservableBoolean = ObservableBoolean(false)
    val user: ObservableField<User?> = ObservableField(prefs.user)
}