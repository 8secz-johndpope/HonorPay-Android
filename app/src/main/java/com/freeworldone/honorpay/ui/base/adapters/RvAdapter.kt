package com.freeworldone.honorpay.ui.base.adapters

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.freeworldone.honorpay.ui.base.items.RvItem

class RvAdapter : RecyclerView.Adapter<RvAdapter.Vh>() {

    init {
        setHasStableIds(true)
    }

    var list = listOf<RvItem>()
        private set

    fun updateList(updatedList: List<RvItem>) {
        list = updatedList
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long = list[position].stableId

    override fun getItemViewType(position: Int): Int = list[position].itemViewRes

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.Vh =
            Vh(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), viewType, parent, false))

    override fun onBindViewHolder(holder: RvAdapter.Vh, pos: Int) {
        val item = list.getOrNull(pos) ?: return
        holder.binding.apply {
            setVariable(item.bindingId, item)
            executePendingBindings()
        }
    }

    override fun getItemCount() = list.size

    class Vh(internal val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}