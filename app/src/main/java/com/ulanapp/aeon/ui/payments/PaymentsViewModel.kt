package com.ulanapp.aeon.ui.payments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ulanapp.aeon.data.actions.APIPaymentsAction
import kotlinx.coroutines.Dispatchers

class PaymentsViewModel(
    private var apiPaymentsAction: APIPaymentsAction
) : ViewModel() {

    // загружаем списки платежей
    fun loadPayments(token: String) = liveData(Dispatchers.IO) {
        emit(apiPaymentsAction.getPayments(token))
    }
}