package com.freeworldone.honorpay.ui.base.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

@BindingAdapter("url")
fun ImageView.loadUrl(url: String?) {
    Picasso.with(context).load(url).into(this)
}