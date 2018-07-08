package com.freeworldone.honorpay.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.databinding.ActivityMainBinding
import com.freeworldone.honorpay.domain.RestAdapter
import com.freeworldone.honorpay.domain.models.response.RecentResponse
import com.freeworldone.honorpay.ui.base.extensions.getViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy { getViewModel<MainViewModel>() }
    private val navController: NavController by lazy { findNavController(R.id.navHostFragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)
        binding.bottomNav.setupWithNavController(navController)
        setSupportActionBar(binding.toolbar)
        binding.collapsingToolbar.isTitleEnabled = false
        setupActionBarWithNavController(navController)

        RestAdapter.recent().enqueue(object : Callback<RecentResponse> {
            override fun onFailure(call: Call<RecentResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<RecentResponse>?, response: Response<RecentResponse>?) {

            }
        })
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()
}
