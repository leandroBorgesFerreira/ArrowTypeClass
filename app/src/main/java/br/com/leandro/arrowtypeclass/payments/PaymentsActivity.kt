package br.com.leandro.arrowtypeclass.payments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import br.com.leandro.arrowtypeclass.R
import br.com.leandro.arrowtypeclass.connection.ApiClient
import br.com.leandro.arrowtypeclass.payments.di.PaymentsDeps
import br.com.leandro.arrowtypeclass.payments.domain.Payment
import br.com.leandro.arrowtypeclass.payments.presentation.getPayments
import br.com.leandro.arrowtypeclass.payments.view.PaymentsView
import br.com.leandro.arrowtypeclass.payments.view.adapter.PaymentsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

class PaymentsActivity : AppCompatActivity(), PaymentsView {

    private val paymentList : MutableList<Payment> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)

        setupList(paymentList)
        getPayments().run(PaymentsDeps(this, ApiClient()))
    }

    private fun setupList(listItems : List<Payment>) {
        paymentListRV.layoutManager = LinearLayoutManager(this)
        paymentListRV.adapter = PaymentsAdapter(listItems, { Log.d("Click", "Got a click!") })
    }

    override fun showNotFoundError() {
        runOnUiThread {
            alert("Generic error!!") {
                yesButton { }
            }.show()
        }
    }

    override fun showGenericError() {
        runOnUiThread {
            alert("Generic error!!") {
                yesButton { }
            }.show()
        }
    }

    override fun showAuthenticationError() {
        runOnUiThread {
            alert("Generic error!!") {
                yesButton { }
            }.show()
        }
    }

    override fun drawRepositories(payments: List<Payment>) {
        paymentList.clear()
        paymentList.addAll(payments)
    }
}
