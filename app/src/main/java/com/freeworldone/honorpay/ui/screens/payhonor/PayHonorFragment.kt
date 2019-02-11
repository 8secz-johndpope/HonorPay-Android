package com.freeworldone.honorpay.ui.screens.payhonor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.freeworldone.honorpay.databinding.FragmentPayHonorBinding
import com.freeworldone.honorpay.ui.base.extensions.getViewModel


class PayHonorFragment : Fragment() {

    private val viewModel: PayHonorViewModel by lazy { getViewModel<PayHonorViewModel>() }
    private lateinit var binding: FragmentPayHonorBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentPayHonorBinding.inflate(inflater, container, false).also {
                binding = it
                binding.vm = viewModel
                binding.lifecycleOwner = this
            }.root
}
