package br.com.leandro.arrowtypeclass.payments.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.leandro.arrowtypeclass.R
import br.com.leandro.arrowtypeclass.payments.domain.Payment
import kotlinx.android.synthetic.main.item_payment.view.*

class PaymentsAdapter(
        private val characters: List<Payment>,
        private val itemClick: (Payment) -> Unit) : RecyclerView.Adapter<PaymentsAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_payment, parent, false)
      return ViewHolder(view, itemClick)
  }

  override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
      holder.bind(characters[pos])
  }

  override fun getItemCount() = characters.size

  class ViewHolder(val view: View, private val itemClick: (Payment) -> Unit) : RecyclerView.ViewHolder(view) {
      fun bind(payment: Payment) {
          with(payment) {
              itemView.setOnClickListener { itemClick(this) }

              itemView.valueTV.text = this.value.toString()
              itemView.dueDateTV.text = this.dueDate.toString()
          }
      }
  }
}
