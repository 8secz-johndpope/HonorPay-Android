package com.freeworldone.honorpay.ui.base.extensions

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.children(): List<View> = mutableListOf<View>().apply {
    for (i in 0 until childCount) {
        add(getChildAt(i))
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean, applyToView: (View.() -> Unit)? = null): View {
    val view = LayoutInflater.from(context).inflate(layoutRes, this, false)
    applyToView?.invoke(view)
    if (attachToRoot) addView(view)
    return view
}

fun <T> ViewGroup.bindChildren(items: List<T>, @LayoutRes layoutId: Int, updateItem: View.(Int, T) -> Unit) {
    if (childCount < items.size) {
        for (i in childCount until items.size) {
            inflate(layoutId, true)
        }
    } else if (childCount > items.size) {
        removeViews(items.size, childCount - items.size)
    }

    for (i in 0 until childCount) {
        getChildAt(i).updateItem(i, items[i])
    }
}