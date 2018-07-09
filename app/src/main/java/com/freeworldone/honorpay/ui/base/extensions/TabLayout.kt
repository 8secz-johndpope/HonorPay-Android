package com.freeworldone.honorpay.ui.base.extensions

import android.databinding.BindingAdapter
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager


@BindingAdapter("pager")
fun TabLayout.pager(pager: ViewPager) {
    setupWithViewPager(pager, true)
}