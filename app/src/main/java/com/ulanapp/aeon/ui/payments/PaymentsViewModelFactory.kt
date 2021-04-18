package com.ulanapp.aeon.ui.payments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.aeon.data.actions.APIPaymentsAction

class PaymentsViewModelFactory(
    private var apiPaymentsAction: APIPaymentsAction
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PaymentsViewModel(apiPaymentsAction) as T
    }
}