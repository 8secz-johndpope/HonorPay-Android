package com.freeworldone.honorpay.ui.base.items

import com.freeworldone.honorpay.BR
import com.freeworldone.honorpay.R

data class EmptyItem(val text: String) : RvItem {
    override val itemViewRes: Int = R.layout.item_empty
    override val stableId: Long = 0L
    override val bindingId: Int = BR.emptyItem
    override fun compareTo(other: RvItem): Int = 0
}