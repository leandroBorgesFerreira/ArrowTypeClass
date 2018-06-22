package br.com.leandro.arrowtypeclass.payments.data

import arrow.data.Reader
import arrow.effects.IO
import br.com.leandro.arrowtypeclass.payments.di.PaymentsDeps
import br.com.leandro.arrowtypeclass.payments.domain.Payment

fun paymentsUseCase() : Reader<PaymentsDeps, IO<List<Payment>>> = fetchAllPayments()
