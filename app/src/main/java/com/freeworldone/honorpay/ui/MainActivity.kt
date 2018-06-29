package com.freeworldone.honorpay.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.databinding.ActivityMainBinding
import com.freeworldone.honorpay.domain.RestAdapter
import com.freeworldone.honorpay.domain.models.response.RecentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(){
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)

        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_profile -> {
                    true
                }
                R.id.nav_pay_honor -> {
                    true
                }
                R.id.nav_about_us -> {
                    true
                }
                R.id.nav_recent -> {
                    true
                }
                else -> false
            }
        }

        RestAdapter.recent().enqueue(object: Callback<RecentResponse>{
            override fun onFailure(call: Call<RecentResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<RecentResponse>?, response: Response<RecentResponse>?) {

            }
        })
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.navHostFragment).navigateUp()
}
