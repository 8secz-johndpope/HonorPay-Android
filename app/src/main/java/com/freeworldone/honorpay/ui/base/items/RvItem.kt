package com.freeworldone.honorpay.ui.base.items

interface RvItem : Comparable<RvItem> {
    val itemViewRes: Int
    val stableId: Long
    val bindingId: Int
    override fun compareTo(other: RvItem): Int = 0
}