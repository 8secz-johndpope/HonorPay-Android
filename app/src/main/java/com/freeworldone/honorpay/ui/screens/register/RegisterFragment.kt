package com.freeworldone.honorpay.ui.screens.register

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freeworldone.honorpay.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        val binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }
}
