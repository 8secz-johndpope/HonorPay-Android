package com.freeworldone.honorpay.ui.recent

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freeworldone.honorpay.R


class RecentFragment : Fragment() {

    companion object {
        fun newInstance() = RecentFragment()
    }

    private lateinit var viewModel: RecentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recent_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
