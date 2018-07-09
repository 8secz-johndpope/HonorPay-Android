package com.freeworldone.honorpay.data.dao

import com.freeworldone.honorpay.ui.base.items.HonorItem
import java.util.*

class HonorDetail(
        val honor_id: Int,
        val user_from: Int,
        val user_to: Int,
        val message: String,
        val timestamp: Long,

        val from_first_name: String,
        val from_last_name: String,
        val from_nickname: String,
        val from_type: Int,
        val from_honors_received: Int,

        val to_first_name: String,
        val to_last_name: String,
        val to_nickname: String,
        val to_type: Int,
        val to_honors_received: Int) {

    fun toHonorItem() = HonorItem(
            id = honor_id,
            fromId = user_from,
            toId = user_to,
            honoredBy = "$from_first_name $from_last_name${if (from_nickname.isBlank()) "" else " ($from_nickname)"}",
            honoredName = "$to_first_name $to_last_name${if (to_nickname.isBlank()) "" else " ($to_nickname)"}",
            honorTotal = to_honors_received,
            imageUrl = null,
            isReceived = true,
            message = message,
            timeAgo = Date(timestamp).toString())
}