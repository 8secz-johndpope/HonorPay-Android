package com.freeworldone.honorpay.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.databinding.ActivityMainBinding
import com.freeworldone.honorpay.domain.RestAdapter
import com.freeworldone.honorpay.ui.base.extensions.getViewModel
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy { getViewModel<MainViewModel>() }
    private val navController: NavController by lazy { findNavController(R.id.navHostFragment) }
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)
        NavigationUI.setupWithNavController(binding.bottomNav, navController)
        NavigationUI.setupWithNavController(binding.collapsingToolbar, binding.toolbar, navController)
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController)
//        setupActionBarWithNavController(navController)

        job = GlobalScope.launch(Dispatchers.IO) {
            val loginResponse = RestAdapter.login("","")
            withContext(Dispatchers.Main){
                loginResponse
            }
        }
    }

    override fun onDestroy() {
        job?.cancel()
        super.onDestroy()
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()
}
