package com.springboot.account.dto

import com.springboot.account.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(
    val id: String,
    val transactionType: TransactionType = TransactionType.INITIAL,
    val amount: BigDecimal = BigDecimal.ZERO,
    val transactionDate: LocalDateTime? = null
)