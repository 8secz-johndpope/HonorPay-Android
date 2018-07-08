package com.freeworldone.honorpay.ui.screens.profile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.freeworldone.honorpay.data.DatabaseManager
import com.freeworldone.honorpay.data.models.User
import com.freeworldone.honorpay.ui.base.items.HonorItem

class ProfileViewModel(userId: Int) : ViewModel() {
    val user: LiveData<User?> = DatabaseManager.db.userDao().get(userId)
    val honorReceived: LiveData<List<HonorItem>> = Transformations.map(DatabaseManager.db.honorDao().getAllToUser(userId)) { it.map { it.toHonorItem() } }
    val honorAwarded: LiveData<List<HonorItem>> = Transformations.map(DatabaseManager.db.honorDao().getAllFromUser(userId)) { it.map { it.toHonorItem() } }
}
