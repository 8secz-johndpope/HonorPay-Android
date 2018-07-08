package com.freeworldone.honorpay.ui.screens.register

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freeworldone.honorpay.databinding.FragmentRegisterBinding
import com.freeworldone.honorpay.ui.base.extensions.getViewModel


class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by lazy { getViewModel<RegisterViewModel>() }
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentRegisterBinding.inflate(inflater, container, false).also {
                binding = it
                binding.vm = viewModel
                binding.setLifecycleOwner(this)
            }.root
}

