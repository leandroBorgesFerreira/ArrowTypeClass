package br.com.leandro.arrowtypeclass.payments.data

import arrow.core.Try
import arrow.data.Reader
import arrow.data.ReaderApi
import arrow.data.map
import arrow.effects.IO
import br.com.leandro.arrowtypeclass.connection.ApiClient
import br.com.leandro.arrowtypeclass.payments.di.PaymentsDeps
import br.com.leandro.arrowtypeclass.payments.domain.Payment
import kotlinx.coroutines.experimental.async

fun fetchAllPayments(): Reader<PaymentsDeps, IO<List<Payment>>> =
        ReaderApi.ask<PaymentsDeps>()
                .map { deps ->
                         IO.async<List<Payment>> { either ->
                             async {
                                 either(queryForRepositories(deps.apiClient).toEither())
                             }
                         }
                     }


private fun queryForRepositories(apiClient: ApiClient): Try<List<Payment>> =
        Try { apiClient.getPayments() }
