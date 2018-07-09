package com.freeworldone.honorpay.ui.screens.profile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.data.DatabaseManager
import com.freeworldone.honorpay.data.models.User
import com.freeworldone.honorpay.ui.base.items.RvItem
import com.freeworldone.honorpay.ui.base.items.TabPageItem

class ProfileViewModel(userId: Int) : ViewModel() {
    val user: LiveData<User?> = DatabaseManager.db.userDao().get(userId)
    val items = listOf(
            TabPageItem(R.layout.tab_profile_about),
            TabPageItem(R.layout.tab_profile_honors_received),
            TabPageItem(R.layout.tab_profile_honors_awarded))
    val honorsReceived: LiveData<List<RvItem>> = Transformations.map(DatabaseManager.db.honorDao().getAllToUser(userId)) { it.map { it.toHonorItem() } }
    val honorsAwarded: LiveData<List<RvItem>> = Transformations.map(DatabaseManager.db.honorDao().getAllFromUser(userId)) { it.map { it.toHonorItem() } }
}
