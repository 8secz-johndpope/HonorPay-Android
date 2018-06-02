package com.freeworldone.honorpay.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.freeworldone.honorpay.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.navigation_home -> message.setText(R.string.title_home).run { true }
                R.id.navigation_dashboard -> message.setText(R.string.title_dashboard).run { true }
                R.id.navigation_notifications -> message.setText(R.string.title_notifications).run { true }
                else -> false
            }
        }
    }
}
