package com.example.movie.repository;

import com.example.movie.model.Account;
import com.example.movie.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
//    List<Customer>
}
