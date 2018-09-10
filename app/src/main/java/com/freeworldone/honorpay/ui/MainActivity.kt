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
import com.freeworldone.honorpay.ui.base.extensions.disposeBy
import com.freeworldone.honorpay.ui.base.extensions.getViewModel
import com.freeworldone.honorpay.ui.base.extensions.log
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
        NavigationUI.setupWithNavController(binding.bottomNav, navController)
        NavigationUI.setupWithNavController(binding.collapsingToolbar, binding.toolbar, navController)
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController)
//        setupActionBarWithNavController(navController)

//        RestAdapter.recent()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        { recents -> log("onSubscribe: recents size: ${recents.size}") } ,
//                        { log("onError: $it") })
//                .disposeBy(disposables)


        RestAdapter.login("colinrturner@gmail.com","p0o9i8u7y6t5")
                .doAfterSuccess { log("first login response: $it") }
                .doOnError { log("first login error: $it") }
                .flatMap { RestAdapter.user(it.id) }
                .doAfterSuccess { log("user response: $it") }
                .doOnError { log("user error: $it") }
                .flatMap { RestAdapter.login("colinrturner@gmail.com","p0u7y6t5") }
                .doAfterSuccess { log("second login response: $it") }
                .doOnError { log("second login error: $it") }
                .subscribe({},{ log("error: $it")})
                .disposeBy(disposables)
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()
}
