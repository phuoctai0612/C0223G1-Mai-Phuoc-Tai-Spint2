package com.example.movie.repository;

import com.example.movie.model.Account;
import com.example.movie.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
