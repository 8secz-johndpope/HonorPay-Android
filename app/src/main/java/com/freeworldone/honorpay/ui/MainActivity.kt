package com.freeworldone.honorpay.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import com.freeworldone.honorpay.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav.setOnNavigationItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.nav_profile -> {true}
                R.id.nav_pay_honor -> {true}
                R.id.nav_about_us -> {true}
                R.id.nav_recent -> {true}
                else -> false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.navHostFragment).navigateUp()
}
