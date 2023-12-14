package com.springboot.account.dto;

import com.springboot.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    public TransactionDto convert(Transaction from) {
        return new TransactionDto(
                        from.getId(),
                from.getTransactionType(),
                        from.getAmount(),
                from.getTransactionDate() // Assuming you also want to include transaction type in the DTO
                );
    }
}
