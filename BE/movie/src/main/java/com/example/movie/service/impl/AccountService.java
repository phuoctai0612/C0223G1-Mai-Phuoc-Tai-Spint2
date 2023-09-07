package com.example.movie.service.impl;

import com.example.movie.model.Account;
import com.example.movie.repository.IAccountRepository;
import com.example.movie.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
@Autowired
private IAccountRepository accountRepository;

    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account loginAccount(String email) {
        return accountRepository.findByNameAccount(email);
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByNameAccount(email);
    }


}
