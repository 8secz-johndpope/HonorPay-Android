package com.freeworldone.honorpay.ui.base.adapters

import android.view.View

interface RvItem : Comparable<RvItem> {
    val itemViewRes: Int
    val stableId: Long
    override fun compareTo(other: RvItem): Int = 0

    fun bind(view: View, clickListener: View.OnClickListener?)
}