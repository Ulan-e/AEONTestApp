package com.ulanapp.aeon.ui.payments

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ulanapp.aeon.data.actions.APIPaymentsAction
import kotlinx.coroutines.Dispatchers

class PaymentsViewModel(
    private var apiPaymentsAction: APIPaymentsAction
) : ViewModel() {

    fun loadPayments(token: String) = liveData(Dispatchers.IO) {
        emit(apiPaymentsAction.getPayments(token))
        Log.d("iamuli", apiPaymentsAction.getPayments(token).toString())
    }
}