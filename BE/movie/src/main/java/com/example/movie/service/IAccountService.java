package com.example.movie.service;

import com.example.movie.model.Account;

public interface IAccountService {
    void createAccount(Account account);
    Account loginAccount(String email);
    Account findByEmail(String email);
}
