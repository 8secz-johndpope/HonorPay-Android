package com.freeworldone.honorpay.ui.base.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("url")
fun ImageView.loadUrl(url: String?) {
    Picasso.get().load(url).into(this)
}