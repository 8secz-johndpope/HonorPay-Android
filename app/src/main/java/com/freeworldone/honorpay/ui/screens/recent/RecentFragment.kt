package com.freeworldone.honorpay.ui.screens.recent

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freeworldone.honorpay.databinding.FragmentRecentBinding


class RecentFragment : Fragment() {

    companion object {
        fun newInstance() = RecentFragment()
    }

    private lateinit var viewModel: RecentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProviders.of(this@RecentFragment).get(RecentViewModel::class.java)
        val binding = FragmentRecentBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }
}
