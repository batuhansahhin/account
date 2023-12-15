package com.springboot.account.service;

import com.springboot.account.model.Account;
import com.springboot.account.model.Transaction;
import com.springboot.account.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private Logger logger = LoggerFactory.getLogger(TransactionService.class);
    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;

    public TransactionService(TransactionRepository transactionRepository, TransactionService transactionService) {
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }

    protected Transaction initiateMoney(final Account account, BigDecimal amount){

        return transactionRepository.save(
                new Transaction(amount, account));
    }
}
