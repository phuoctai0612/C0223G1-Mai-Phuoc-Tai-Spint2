package com.example.movie.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @OneToOne
    private Account account;

    public Customer() {
    }


    public Customer(String email) {
        this.email = email;
    }

    public Customer(String email, Account account) {
        this.email = email;
        this.account = account;
    }

    public Customer(Long id, String email, Account account) {
        this.id = id;
        this.email = email;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
