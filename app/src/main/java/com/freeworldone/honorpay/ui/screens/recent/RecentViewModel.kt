package com.freeworldone.honorpay.ui.screens.recent

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.freeworldone.honorpay.data.DatabaseManager
import com.freeworldone.honorpay.ui.base.items.RvItem

class RecentViewModel : ViewModel() {
    val recentHonors: LiveData<List<RvItem>> = Transformations.map(DatabaseManager.db.honorDao().getAllRecent()) { it.map { it.toHonorItem() } }
}
