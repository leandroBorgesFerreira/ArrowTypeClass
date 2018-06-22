package br.com.leandro.arrowtypeclass.payments.view

import br.com.leandro.arrowtypeclass.payments.domain.Payment

interface PaymentsView {
    fun showNotFoundError()
    fun showGenericError()
    fun showAuthenticationError()
    fun drawRepositories(payments: List<Payment>)
}
