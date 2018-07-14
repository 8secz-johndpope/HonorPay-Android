package com.freeworldone.honorpay.ui.screens.profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.databinding.FragmentProfileBinding
import com.freeworldone.honorpay.ui.base.extensions.SAVED_USER_ID
import com.freeworldone.honorpay.ui.base.extensions.getViewModel
import com.freeworldone.honorpay.ui.base.extensions.prefs


class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by lazy {
        getViewModel {
            ProfileFragmentArgs.fromBundle(arguments).userId
                    .let { ProfileViewModel(if (it != 0) it else prefs.getInt(SAVED_USER_ID, 0)) }
        }
    }
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentProfileBinding.inflate(inflater, container, false).also {
                binding = it
                binding.vm = viewModel
                binding.setLifecycleOwner(this)
                if (viewModel.user.value == null) findNavController().navigate(R.id.login)
            }.root
}
