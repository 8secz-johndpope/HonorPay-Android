package com.freeworldone.honorpay.ui.base.adapters

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freeworldone.honorpay.BR
import com.freeworldone.honorpay.ui.base.items.TabPageItem

class ViewPagerAdapter : PagerAdapter() {

    var items: List<TabPageItem> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = items[position]
        return DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(container.context), item.itemViewRes, container, false).apply {
            setVariable(BR.vm, item)
            root.tag = item.itemViewRes
            executePendingBindings()
        }
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean = (view === `object`)

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView((`object` as View))
    }

    override fun getCount(): Int = items.size
    override fun getItemPosition(`object`: Any): Int {
        val view = `object` as View
        val i = items.indexOfFirst { it.itemViewRes == view.tag }
        return if (i == -1) POSITION_NONE else i
    }
}