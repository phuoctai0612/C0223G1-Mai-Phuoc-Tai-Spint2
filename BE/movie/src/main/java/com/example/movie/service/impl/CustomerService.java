package com.example.movie.service.impl;

import com.example.movie.model.Customer;
import com.example.movie.repository.ICustomerRepository;
import com.example.movie.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public void createCustomer(Customer customer) {
         customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
