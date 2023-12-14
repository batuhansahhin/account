package com.springboot.account.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Transaction(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,

    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    val transactionDate: LocalDateTime?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "account_id", nullable = false, referencedColumnName = "id") // Assuming the foreign key column name is "account_id"
    val account: Account?,

    @OneToMany(mappedBy = "transaction", fetch = FetchType.LAZY)
    val relatedTransactions: Set<Transaction>? = emptySet()
) {
    // Secondary constructor with default parameter values
    constructor(
        amount: BigDecimal,
        account: Account
    ) : this(
        id = null,
        amount = amount,
        transactionDate = LocalDateTime.now(), // Provide a default value or adjust as needed
        transactionType = TransactionType.INITIAL, // Provide a default value or adjust as needed
        account = account
    )
        override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Transaction

        if (id != other.id) return false
        if (transactionType != other.transactionType) return false
        if (amount != other.amount) return false
        if (transactionDate != other.transactionDate) return false
        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (transactionType?.hashCode() ?: 0)
        result = 31 * result + (amount?.hashCode() ?: 0)
        result = 31 * result + (transactionDate?.hashCode() ?: 0)
        return result
    }
}

enum class TransactionType{
    INITIAL, TRANSFER
}