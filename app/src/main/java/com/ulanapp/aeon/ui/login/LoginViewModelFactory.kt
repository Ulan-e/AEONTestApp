package com.ulanapp.aeon.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.aeon.data.actions.APILoginAction

class LoginViewModelFactory(
    private var apiLoginAction: APILoginAction
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(apiLoginAction) as T
    }
}