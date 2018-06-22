package br.com.leandro.arrowtypeclass.payments.presentation

import arrow.data.Reader
import arrow.data.ReaderApi
import arrow.data.flatMap
import arrow.data.map
import br.com.leandro.arrowtypeclass.payments.data.paymentsUseCase
import br.com.leandro.arrowtypeclass.payments.di.PaymentsDeps
import br.com.leandro.arrowtypeclass.payments.domain.Payment
import br.com.leandro.arrowtypeclass.payments.view.PaymentsView

fun getPayments(): Reader<PaymentsDeps, Unit> =
        ReaderApi.ask<PaymentsDeps>()
            .flatMap { (view) ->
                 paymentsUseCase()
                     .map { io ->
                              io.unsafeRunAsync { reposEither ->
                                  reposEither.fold(
                                          { view.showGenericError() },
                                          { paymentList -> drawRepos(paymentList, view) })
                              }
                          }

             }

private fun drawRepos(paymentList: List<Payment>, view: PaymentsView) {
    view.drawRepositories(paymentList)
}
