package com.freeworldone.honorpay.ui.screens.recent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freeworldone.honorpay.databinding.FragmentRecentBinding
import com.freeworldone.honorpay.ui.base.adapters.RvAdapter
import com.freeworldone.honorpay.ui.base.extensions.getViewModel
import com.freeworldone.honorpay.ui.base.items.HonorItem


class RecentFragment : Fragment(), View.OnClickListener {

    private val viewModel: RecentViewModel by lazy { getViewModel<RecentViewModel>() }
    private lateinit var binding: FragmentRecentBinding
    private val adapter: RvAdapter<HonorItem> = RvAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentRecentBinding.inflate(inflater, container, false).also {
                binding = it
                binding.vm = viewModel
                binding.setLifecycleOwner(this)
                binding.rvRecent.adapter = adapter
                //TODO: check observe methods, move adapter to viewModel?
                viewModel.recentHonors.observeForever { adapter.updateList(it ?: listOf()) }
            }.root

    override fun onClick(v: View) {
    }
}
