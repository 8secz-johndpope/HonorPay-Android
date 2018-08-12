package com.freeworldone.honorpay.ui.base.extensions

import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.freeworldone.honorpay.ui.base.adapters.ViewPagerAdapter
import com.freeworldone.honorpay.ui.base.items.TabPageItem

@BindingAdapter("items")
fun ViewPager.items(items: List<TabPageItem>){
    val adapter = adapter as? ViewPagerAdapter ?: ViewPagerAdapter().also { this.adapter = it }
    adapter.items = items
}