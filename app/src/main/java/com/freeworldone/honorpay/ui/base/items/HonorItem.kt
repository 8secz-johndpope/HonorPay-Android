package com.freeworldone.honorpay.ui.base.items

import com.freeworldone.honorpay.BR
import com.freeworldone.honorpay.R

data class HonorItem(
        val id: Int,
        val fromId: Int,
        val toId: Int,
        val honoredBy: String?,
        val honoredName: String,
        val honorTotal: Int,
        val imageUrl: String?,
        val isReceived: Boolean,
        val message: String,
        val timeAgo: String): RvItem {
    override val itemViewRes: Int = R.layout.item_honor
    override val stableId: Long = id.toLong()
    override val bindingId: Int = BR.honorItem
}