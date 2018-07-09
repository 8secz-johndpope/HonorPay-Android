package com.freeworldone.honorpay.ui.base.views

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.MotionEvent
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.ui.base.extensions.cycleExpansion
import com.freeworldone.honorpay.ui.base.extensions.drawable

class ExpandableTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        maxLines = 4
        isFocusable = true
        isClickable = true
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        super.setText(text, type)
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, when {
            lineCount <= 4 -> null
            maxLines > 4 -> drawable(R.drawable.ic_expand_less_24dp)
            else -> drawable(R.drawable.ic_expand_more_24dp)
        })
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (lineCount > 4 && event.action == MotionEvent.ACTION_UP) cycleExpansion(4)
        return super.onTouchEvent(event)
    }
}