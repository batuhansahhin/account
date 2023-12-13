package com.springboot.account.service;

import com.springboot.account.exception.CustomerNotFoundException;
import com.springboot.account.model.Customer;
import com.springboot.account.repository.CustomerRepository;

public class CustomerService {

    private final CustomerRepository customerRepository;

    private CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(String id){
        return customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer Not Found By ID" + id));
    }
}
