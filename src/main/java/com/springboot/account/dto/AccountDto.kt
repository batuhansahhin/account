package com.springboot.account.dto

import com.springboot.account.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(

    val id: String?,
    val balance: BigDecimal?,
    val creationDate: LocalDateTime,
    val customer: AccountCustomerDto?,
    val transaction: MutableSet<Transaction>?
    )