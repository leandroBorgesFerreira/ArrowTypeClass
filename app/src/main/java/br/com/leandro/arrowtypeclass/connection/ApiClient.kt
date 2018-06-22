package br.com.leandro.arrowtypeclass.connection

import br.com.leandro.arrowtypeclass.payments.domain.Payment
import org.threeten.bp.LocalDate

class ApiClient {
    fun getPayments() : List<Payment> =
            listOf(Payment(100, LocalDate.now()),
                   Payment(120, LocalDate.now().plusMonths(1)),
                   Payment(150, LocalDate.now().plusMonths(2)),
                   Payment(110, LocalDate.now().plusMonths(3)))
}
