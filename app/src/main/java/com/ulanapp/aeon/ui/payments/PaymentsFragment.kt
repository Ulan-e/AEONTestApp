package com.ulanapp.aeon.ui.payments

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.aeon.ui.MainActivity
import com.ulanapp.aeon.R
import com.ulanapp.aeon.data.actions.APIPaymentsAction
import com.ulanapp.aeon.data.actions.APIPaymentsActionImpl
import com.ulanapp.aeon.data.responses.PaymentsResponse
import com.ulanapp.aeon.utils.GlobalPref
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_payments.*
import javax.inject.Inject

class PaymentsFragment : DaggerFragment() {

    @Inject
    lateinit var apiPaymentsAction: APIPaymentsAction

    @Inject
    lateinit var adapter: PaymentsAdapter

    private lateinit var paymentsViewModel: PaymentsViewModel
    private var token: String = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
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

        setToolbarOptions(view)

        token = GlobalPref.token

        paymentsViewModel = ViewModelProvider(this, PaymentsViewModelFactory(apiPaymentsAction))
            .get(PaymentsViewModel::class.java)
        paymentsViewModel.loadPayments(token).observe(viewLifecycleOwner, {
            setupAdapter(it.response)
        })
    }

    private fun setToolbarOptions(view: View) {
        val toolbar = view.findViewById<Toolbar>(R.id.paymentsToolbar)
        toolbar.inflateMenu(R.menu.exit_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.logout -> showLogOutDialog()
            }
            true
        }
    }

    private fun showLogOutDialog() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        alertDialog.setTitle(resources.getString(R.string.want_to_logout))
        alertDialog.setPositiveButton(resources.getString(R.string.exit)) { _, _ ->
            clearUserData()
            restartApp()
        }
        alertDialog.setNegativeButton(resources.getString(R.string.cancel)) { dialog, _ ->
            dialog.cancel()
        }
        val alert = alertDialog.create()
        alert.show()
        alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.GRAY)
    }

    private fun clearUserData() {
        GlobalPref.apply {
            loggedIn = false
            token = ""
        }
    }

    private fun restartApp() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        requireActivity().startActivity(intent)
        requireActivity().finishAffinity()
    }

    // ставим адаптер
    private fun setupAdapter(payments: List<PaymentsResponse.Response>) {
        adapter.setData(payments)
        rvPayments.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}