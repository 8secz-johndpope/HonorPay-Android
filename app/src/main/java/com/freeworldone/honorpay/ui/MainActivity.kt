package com.freeworldone.honorpay.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.freeworldone.honorpay.R
import com.freeworldone.honorpay.data.enums.UserType
import com.freeworldone.honorpay.databinding.ActivityMainBinding
import com.freeworldone.honorpay.domain.RestAdapter
import com.freeworldone.honorpay.ui.base.extensions.getViewModel
import com.freeworldone.honorpay.ui.base.extensions.log
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


//        FirebaseAuth.getInstance().currentUser?.also {
//            it.email
//            it.isAnonymous
//        }
//
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("").requestEmail().build()
//
//        GoogleSignIn.getLastSignedInAccount(this)

//        val providers = listOf(
//                AuthUI.IdpConfig.EmailBuilder().build(),
//                AuthUI.IdpConfig.PhoneBuilder().build(),
//                AuthUI.IdpConfig.GoogleBuilder().build())
//
//        startActivityForResult(AuthUI.getInstance()
//                .createSignInIntentBuilder()
//                .setAvailableProviders(providers)
//                .build(), RC_SIGN_IN)

        job = GlobalScope.launch(Dispatchers.IO) {
            val newUser = RestAdapter.newUser(
                    firstName = "FirstName",
                    lastName = "LastName",
                    nickname = "Nickname",
                    region = "Region",
                    country = "Country",
                    attributes = "Attributes",
                    email = "jim+test0001@ohno.run",
                    password = "testPw123",
                    signature = "Signature",
                    userType = UserType.UNCONFIRMED,
                    notificationsAllowed = true,
                    remindersAllowed = true)
            val user = RestAdapter.user(1)
            val loginResponse = RestAdapter.login("jim+test0001@ohno.run", "testPw123")
            withContext(Dispatchers.Main) {
                log("$newUser")
                log("$user")
                log("$loginResponse")
            }
        }
    }

    override fun onDestroy() {
        job?.cancel()
        super.onDestroy()
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == RC_SIGN_IN) {
//            val response = IdpResponse.fromResultIntent(data)
//            if (resultCode == Activity.RESULT_OK) {
//                // Successfully signed in
//                val user = FirebaseAuth.getInstance().currentUser
//                log("user: email: ${user?.email}, photoUrl: ${user?.photoUrl}, phoneNumber: ${user?.phoneNumber}, displayName: ${user?.displayName}, uid: ${user?.uid}, isEmailVerified: ${user?.isEmailVerified}")
//            } else {
//                log("sign in failed, user: ${FirebaseAuth.getInstance().currentUser}, error: ${response?.error}")
//            }
//        }
//    }
//
//    companion object {
//        private const val RC_SIGN_IN = 123
//    }
}
