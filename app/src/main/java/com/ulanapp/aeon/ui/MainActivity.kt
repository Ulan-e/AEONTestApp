package com.ulanapp.aeon.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ulanapp.aeon.R
import com.ulanapp.aeon.ui.login.LoginFragment
import com.ulanapp.aeon.ui.payments.PaymentsFragment
import com.ulanapp.aeon.utils.GlobalPref
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)

        if (GlobalPref.loggedIn) {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, PaymentsFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, LoginFragment())
                .commit()
        }
    }
}