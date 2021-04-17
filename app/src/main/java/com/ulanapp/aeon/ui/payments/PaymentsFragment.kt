package com.ulanapp.aeon.ui.payments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.aeon.R
import com.ulanapp.aeon.data.actions.APIPaymentsActionImpl

class PaymentsFragment : Fragment() {

    private lateinit var paymentsViewModel: PaymentsViewModel
    private var token: String = ""

    companion object {
        private const val TOKEN = "token"

        fun newInstance(token: String) = PaymentsFragment().apply {
            arguments = Bundle(1).apply {
                putString(TOKEN, token)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiPaymentsAction = APIPaymentsActionImpl()

        token = requireArguments().getString(TOKEN, "")

        paymentsViewModel = ViewModelProvider(this, PaymentsViewModelFactory(apiPaymentsAction))
            .get(PaymentsViewModel::class.java)
        paymentsViewModel.loadPayments("123456789").observe(viewLifecycleOwner, {
            Log.d("iamuli", "Result Payments --->>  ${it.response.size}")
        })
    }
}