package com.freeworldone.honorpay.ui.screens.profile

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.data.models.User
import com.freeworldone.honorpay.ui.base.items.RvItem
import com.freeworldone.honorpay.ui.base.items.TabPageItem

class ProfileViewModel(user: User?) : ViewModel() {
    val user: ObservableField<User?> = ObservableField(user)//DatabaseManager.db.userDao().get(userId)
    val items = listOf(
            TabPageItem(R.layout.tab_profile_about),
            TabPageItem(R.layout.tab_profile_honors_received),
            TabPageItem(R.layout.tab_profile_honors_awarded))
    val honorsReceived: ObservableArrayList<RvItem> = ObservableArrayList()
    val honorsAwarded: ObservableArrayList<RvItem> = ObservableArrayList()
//    val honorsReceived: LiveData<List<RvItem>> = Transformations.map(DatabaseManager.db.honorDao().getAllToUser(userId)) { it.map { it.toHonorItem() } }
//    val honorsAwarded: LiveData<List<RvItem>> = Transformations.map(DatabaseManager.db.honorDao().getAllFromUser(userId)) { it.map { it.toHonorItem() } }
}
