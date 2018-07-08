package com.freeworldone.honorpay.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.freeworldone.honorpay.appContext
import com.freeworldone.honorpay.data.DatabaseManager
import com.freeworldone.honorpay.data.models.User
import com.freeworldone.honorpay.ui.base.extensions.SAVED_USER_ID
import com.freeworldone.honorpay.ui.base.extensions.prefs

class MainViewModel : ViewModel() {
    val appBarExpanded: ObservableBoolean = ObservableBoolean(false)
    val user: LiveData<User?> = DatabaseManager.db.userDao().get(appContext.prefs.getInt(SAVED_USER_ID, -1))
}