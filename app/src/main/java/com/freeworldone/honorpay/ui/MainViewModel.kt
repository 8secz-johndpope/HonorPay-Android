package com.freeworldone.honorpay.ui

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField

class MainViewModel : ViewModel() {
    val profileUrl: ObservableField<String?> = ObservableField()
    val isAppBarExpanded: ObservableBoolean = ObservableBoolean(false)
//    val toolbarTitle: LiveData<String>
}