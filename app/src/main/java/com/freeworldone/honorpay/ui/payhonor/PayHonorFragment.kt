package com.freeworldone.honorpay.ui.payhonor

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freeworldone.honorpay.R


class PayHonorFragment : Fragment() {

    companion object {
        fun newInstance() = PayHonorFragment()
    }

    private lateinit var viewModel: PayHonorViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.pay_honor_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PayHonorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
