package com.freeworldone.honorpay.ui.screens.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.databinding.FragmentProfileBinding
import com.freeworldone.honorpay.ui.base.extensions.getViewModel


class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by lazy { getViewModel { ProfileViewModel(ProfileFragmentArgs.fromBundle(arguments).user) } }
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentProfileBinding.inflate(inflater, container, false).also {
                binding = it
                binding.vm = viewModel
                binding.setLifecycleOwner(this)
                if (viewModel.user.get() == null) findNavController(this).navigate(R.id.login)
            }.root
}
