package com.freeworldone.honorpay.ui.base.extensions

import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


@BindingAdapter("pager")
fun TabLayout.pager(pager: ViewPager) {
    setupWithViewPager(pager, true)
}