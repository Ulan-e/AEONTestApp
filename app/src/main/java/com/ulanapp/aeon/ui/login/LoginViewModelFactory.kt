package com.ulanapp.aeon.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.aeon.data.actions.APILoginActionImpl

class LoginViewModelFactory(
    private var apiLoginAction: APILoginActionImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(apiLoginAction) as T
    }
}