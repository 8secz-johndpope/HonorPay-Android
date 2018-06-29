package com.freeworldone.honorpay.ui.screens.recent

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel;
import com.freeworldone.honorpay.data.DatabaseManager
import com.freeworldone.honorpay.ui.base.items.HonorItem
import java.util.*

class RecentViewModel : ViewModel() {
    //TODO
    val recentHonors: LiveData<List<HonorItem>> = Transformations.map(DatabaseManager.db.honorDao().getAllRecent()) {
        it.map {
            HonorItem(
                    honoredBy = "${it.from_first_name} ${it.from_last_name}${if(it.from_nickname.isBlank()) "" else " (${it.from_nickname})"}",
                    honoredName = "${it.to_first_name} ${it.to_last_name}${if(it.to_nickname.isBlank()) "" else " (${it.to_nickname})"}",
                    honorTotal = it.to_honors_received,
                    imageUrl = null,
                    isMessageExpanded = false,
                    isReceived = true,
                    message = it.message,
                    timeAgo = Date(it.timestamp).toString())
        }
    }
}
