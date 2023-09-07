package com.example.movie.service;

import com.example.movie.model.Customer;

public interface ICustomerService {
    void createCustomer(Customer customer);
    Customer findCustomerById(Long id);
}
