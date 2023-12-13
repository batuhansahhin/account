package com.springboot.account.dto;

import com.springboot.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    public Transaction convert(Transaction from) {
        return new Transaction(
                from.getId(),
                from.getTransactionDate(),
                from.getAmount(),
                from.getTransactionDate()
        );
    }
}
