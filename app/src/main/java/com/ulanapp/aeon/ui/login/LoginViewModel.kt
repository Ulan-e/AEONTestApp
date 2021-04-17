package com.ulanapp.aeon.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ulanapp.aeon.data.actions.APILoginActionImpl
import kotlinx.coroutines.Dispatchers

class LoginViewModel(
    private var apiLoginAction: APILoginActionImpl
) : ViewModel() {

    fun doLogin(login: String,password: String) = liveData(Dispatchers.IO) {
        emit(apiLoginAction.doLogin(login, password))
    }
}