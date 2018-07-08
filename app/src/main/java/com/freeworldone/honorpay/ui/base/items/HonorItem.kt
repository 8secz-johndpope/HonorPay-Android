package com.freeworldone.honorpay.ui.base.items

import android.view.View
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.ui.base.adapters.RvItem

data class HonorItem(
        val id: Int,
        val honoredBy: String?,
        val honoredName: String,
        val honorTotal: Int,
        val imageUrl: String?,
        val isMessageExpanded: Boolean,
        val isReceived: Boolean,
        val message: String,
        val timeAgo: String): RvItem{
    override val itemViewRes: Int = R.layout.item_honor
    override val stableId: Long = id.toLong()

    override fun bind(view: View, clickListener: View.OnClickListener?) {
    }

}