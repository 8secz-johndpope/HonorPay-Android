package com.freeworldone.honorpay.ui.screens.profile

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    //TODO: Fix crash- viewModel requires arguments
    private val viewModel: ProfileViewModel by lazy {  ViewModelProviders.of(this).get(ProfileViewModel::class.java) }
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentProfileBinding.inflate(inflater, container, false).also {
                binding = it
                binding.vm = viewModel
                binding.setLifecycleOwner(this)
                if(viewModel.user.value == null) findNavController().navigate(R.id.login)
            }.root
}
