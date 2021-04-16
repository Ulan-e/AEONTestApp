package com.ulanapp.aeon.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.aeon.R
import com.ulanapp.aeon.data.actions.APILoginActionImpl

class LoginFragment: Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiLoginAction = APILoginActionImpl()

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory(apiLoginAction))
            .get(LoginViewModel::class.java)

    }
}