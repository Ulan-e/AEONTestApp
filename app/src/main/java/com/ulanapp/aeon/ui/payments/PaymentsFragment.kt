package com.ulanapp.aeon.ui.payments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ulanapp.aeon.R
import com.ulanapp.aeon.data.actions.APIPaymentsActionImpl
import com.ulanapp.aeon.data.responses.PaymentsResponse
import kotlinx.android.synthetic.main.fragment_payments.*

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
            setupAdapter(it.response)
        })
    }

    // ставим адаптер
    private fun setupAdapter(payments: List<PaymentsResponse.Response>)   {
        val adapter = PaymentsAdapter()
        adapter.setData(payments)
        rvPayments.adapter = adapter
        rvPayments.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.HORIZONTAL
            )
        )
        adapter.notifyDataSetChanged()
    }
}