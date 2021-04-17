package com.ulanapp.aeon.ui.payments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ulanapp.aeon.R
import com.ulanapp.aeon.data.responses.PaymentsResponse
import kotlinx.android.synthetic.main.payments_list_item.view.*

class PaymentsAdapter : RecyclerView.Adapter<PaymentsAdapter.PaymentsViewHolder>() {

    private lateinit var paymentsList: List<PaymentsResponse.Response>

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

    fun setData(payments: List<PaymentsResponse.Response>){
        paymentsList = payments
    }

    class PaymentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(payment: PaymentsResponse.Response){
            itemView.tvDesc.text = payment.desc
            itemView.tvAmount.text = payment.amount.toString()
            itemView.tvCurrency.text = payment.currency
            itemView.tvCreated.text = payment.created.toString()
        }
    }
}