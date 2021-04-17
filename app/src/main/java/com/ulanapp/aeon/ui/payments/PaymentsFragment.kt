package com.ulanapp.aeon.ui.payments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.aeon.MainActivity
import com.ulanapp.aeon.R
import com.ulanapp.aeon.data.actions.APIPaymentsActionImpl
import com.ulanapp.aeon.data.responses.PaymentsResponse
import com.ulanapp.aeon.utils.GlobalPref
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

        val toolbar = view.findViewById<Toolbar>(R.id.paymentsToolbar)
        toolbar.inflateMenu(R.menu.exit_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.logout -> doLogOut()
            }
            true
        }

        val apiPaymentsAction = APIPaymentsActionImpl()

        token = requireArguments().getString(TOKEN, "")

        paymentsViewModel = ViewModelProvider(this, PaymentsViewModelFactory(apiPaymentsAction))
            .get(PaymentsViewModel::class.java)
        paymentsViewModel.loadPayments(token).observe(viewLifecycleOwner, {
            setupAdapter(it.response)
        })
    }

    private fun doLogOut() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        alertDialog.setTitle("Хотите выйти?")
        alertDialog.setPositiveButton("Да") { _, _ ->
            GlobalPref.apply {
                loggedIn = false
                token = ""
            }
            val intent = Intent(requireContext(), MainActivity::class.java)
            requireActivity().startActivity(intent)
            requireActivity().finishAffinity()
        }
        alertDialog.setNegativeButton("Отмена") { dialog, _ ->
            dialog.cancel()
        }
        val alert = alertDialog.create()
        alert.show()
    }

    // ставим адаптер
    private fun setupAdapter(payments: List<PaymentsResponse.Response>) {
        val adapter = PaymentsAdapter()
        adapter.setData(payments)
        rvPayments.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}