package com.ulanapp.aeon.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ulanapp.aeon.data.actions.APILoginAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class LoginViewModel(
    private var apiLoginAction: APILoginAction
) : ViewModel() {

    val token = MutableLiveData<String>()

    init {
        viewModelScope.launch {

        }
    }

    suspend fun login(login: String, password: String) {
        withContext(Dispatchers.Default) {
            val response = apiLoginAction.doLogin(login, password)
            try {
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            token.value = it.toString()
                        }
                    } else {
                        Log.e("iamuli", "ошибка")
                    }
                }
            } catch (e: HttpException) {
                Log.e("iamuli", "Exception ${e.message}")
            } catch (e: Throwable) {
                Log.e("iamuli", "Ooops: Something else went wrong")
            }
        }
    }
}