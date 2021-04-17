package com.ulanapp.aeon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ulanapp.aeon.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, LoginFragment())
            .commit()
    }
}