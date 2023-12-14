package com.springboot.account.service;

import com.springboot.account.dto.AccountDto;
import com.springboot.account.dto.CreateAccountRequest;
import com.springboot.account.model.Account;
import com.springboot.account.model.Customer;
import com.springboot.account.model.Transaction;
import com.springboot.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    public AccountService(AccountRepository accountRepository, CustomerService customerService){
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getCustomerId(),
                LocalDateTime.now()
                );

        if(createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0){
            Transaction transaction = transactionService.createTransaction();
        }
    }

}
