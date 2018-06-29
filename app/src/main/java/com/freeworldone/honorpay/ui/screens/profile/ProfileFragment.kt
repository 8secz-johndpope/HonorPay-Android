package com.freeworldone.honorpay.ui.screens.profile

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freeworldone.honorpay.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProviders.of(this@ProfileFragment).get(ProfileViewModel::class.java)
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }
}
