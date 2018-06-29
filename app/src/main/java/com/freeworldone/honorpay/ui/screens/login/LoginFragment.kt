package com.freeworldone.honorpay.ui.screens.login

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freeworldone.honorpay.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProviders.of(this@LoginFragment).get(LoginViewModel::class.java)
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }
}
