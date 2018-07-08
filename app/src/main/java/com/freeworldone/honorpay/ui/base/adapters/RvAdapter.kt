package com.freeworldone.honorpay.ui.base.adapters

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.freeworldone.honorpay.ui.base.extensions.inflate

class RvAdapter<T: RvItem>(internal val onClickListener: View.OnClickListener?) : RecyclerView.Adapter<RvAdapter.Vh>() {

    var emptyView = EmptyView(0) {}
        set(value) {
            field = value
            if (list.isEmpty()) notifyDataSetChanged()
        }

    init {
        setHasStableIds(true)
    }

    var list = listOf<T>()
        private set

    fun updateList(updatedList: List<T>) {
        list = updatedList
        notifyDataSetChanged()
    }

    fun addItem(item: T, position: Int = -1) {
        val index = indexOf(item)
        if (index != -1) {
            updateItem(item, index)
            return
        }
        list = list.toMutableList().apply {
            if (position >= 0) add(position, item)
            else {
                add(item)
                sort()
            }
        }
        if (position >= 0) notifyItemInserted(position)
        else notifyItemInserted(list.indexOf(item))
    }

    fun updateItem(item: T) {
        updateItem(item, indexOf(item))
    }

    fun removeItem(item: T) {
        removeItem(indexOf(item))
    }

    fun indexOf(item: T): Int {
        return list.indexOfFirst { it.stableId == item.stableId }
    }

    private fun updateItem(item: T, index: Int) {
        if (index == -1) return
        list = list.toMutableList().apply { set(index, item) }
        notifyItemChanged(index)
    }

    private fun removeItem(position: Int) {
        if (position < 0 || position > list.size) return
        list = list.toMutableList().apply { removeAt(position) }
        notifyItemRemoved(position)
    }

    private val isPlaceholder: Boolean get() = list.isEmpty() && emptyView.viewRes != 0

    override fun getItemId(position: Int): Long = if (isPlaceholder) emptyView.viewRes.toLong() else list[position].stableId

    override fun getItemViewType(position: Int): Int = if (isPlaceholder) emptyView.viewRes else list[position].itemViewRes

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh = RvAdapter.Vh(
            if (viewType == 0) View(parent.context)
            else parent.inflate(viewType, false))

    override fun onBindViewHolder(holder: RvAdapter.Vh, pos: Int) {
        if (isPlaceholder) emptyView.binding.invoke(holder.itemView)
        list.getOrNull(pos)?.bind(holder.itemView, onClickListener)
    }

    override fun getItemCount() = if (isPlaceholder) 1 else list.size

    class Vh(v: View) : RecyclerView.ViewHolder(v)

    data class EmptyView(@LayoutRes val viewRes: Int, val binding: View.() -> Unit)
}