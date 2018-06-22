package br.com.leandro.arrowtypeclass.payments.di

import br.com.leandro.arrowtypeclass.connection.ApiClient
import br.com.leandro.arrowtypeclass.payments.view.PaymentsView

data class PaymentsDeps(val view: PaymentsView,
                        val apiClient: ApiClient)
