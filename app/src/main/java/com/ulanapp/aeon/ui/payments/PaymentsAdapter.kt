package com.ulanapp.aeon.ui.payments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ulanapp.aeon.R
import com.ulanapp.aeon.data.responses.PaymentsResponse
import com.ulanapp.aeon.utils.*
import kotlinx.android.synthetic.main.payments_list_item.view.*
import javax.inject.Inject

class PaymentsAdapter @Inject constructor() :
    RecyclerView.Adapter<PaymentsAdapter.PaymentsViewHolder>() {

    private lateinit var paymentsList: List<PaymentsResponse.PaymentInfo>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentsViewHolder {
        return PaymentsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.payments_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PaymentsViewHolder, position: Int) {
        val payment = paymentsList[position]
        holder.bind(payment)
    }

    override fun getItemCount(): Int {
        return paymentsList.size
    }

    // ставим данные в адаптер
    fun setData(payments: List<PaymentsResponse.PaymentInfo>) {
        paymentsList = payments
    }

    class PaymentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(payment: PaymentsResponse.PaymentInfo) {
            itemView.tvDesc.text = payment.desc.removeDuplicates()
            itemView.tvAmount.text =  payment.amount.convertAmountToDecimalFormat()
            itemView.tvCurrency.text = payment.currency.checkCurrency()
            itemView.tvCreated.text = payment.created.setCreatedTime()
        }
    }
}