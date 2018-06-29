package com.freeworldone.honorpay.ui.screens.payhonor

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freeworldone.honorpay.databinding.FragmentPayHonorBinding


class PayHonorFragment : Fragment() {

    companion object {
        fun newInstance() = PayHonorFragment()
    }

    private lateinit var viewModel: PayHonorViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProviders.of(this@PayHonorFragment).get(PayHonorViewModel::class.java)
        val binding = FragmentPayHonorBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }
}
