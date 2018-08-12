package com.freeworldone.honorpay.ui.base.extensions

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.freeworldone.honorpay.ui.base.adapters.RvAdapter
import com.freeworldone.honorpay.ui.base.items.RvItem


@BindingAdapter("items")
fun RecyclerView.setItems(items: List<RvItem>?) {
    val adapter = adapter as? RvAdapter ?: RvAdapter().also { this.adapter = it }
    adapter.updateList(items ?: listOf())
}