package br.com.leandro.arrowtypeclass.payments.domain

import org.threeten.bp.LocalDate

data class Payment(val value: Long, val dueDate: LocalDate)
