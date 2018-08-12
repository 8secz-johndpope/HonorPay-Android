package com.freeworldone.honorpay.ui.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.freeworldone.honorpay.databinding.FragmentLoginBinding
import com.freeworldone.honorpay.ui.base.extensions.getViewModel


class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by lazy { getViewModel<LoginViewModel>() }
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentLoginBinding.inflate(inflater, container, false).also {
                binding = it
                binding.vm = viewModel
                binding.setLifecycleOwner(this)
            }.root
}
