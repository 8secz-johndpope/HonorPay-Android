package com.freeworldone.honorpay.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.databinding.ActivityMainBinding
import com.freeworldone.honorpay.domain.RestAdapter
import com.freeworldone.honorpay.ui.base.extensions.disposeBy
import com.freeworldone.honorpay.ui.base.extensions.getViewModel
import com.freeworldone.honorpay.ui.base.extensions.log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy { getViewModel<MainViewModel>() }
    private val navController: NavController by lazy { findNavController(R.id.navHostFragment) }
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)
//        binding.bottomNav.setupWithNavController(navController)
//        binding.collapsingToolbar.setupWithNavController(binding.toolbar, navController)
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(this, navController)

        RestAdapter.recent()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { it.forEach { log("onSubscribe: $it") } },
                        { log("onError: $it") })
                .disposeBy(disposables)
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()
}
