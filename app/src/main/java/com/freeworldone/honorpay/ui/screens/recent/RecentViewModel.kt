package com.freeworldone.honorpay.ui.screens.recent

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.freeworldone.honorpay.ui.base.items.RvItem

class RecentViewModel : ViewModel() {
    val recentHonors: ObservableArrayList<RvItem> = ObservableArrayList()
}
