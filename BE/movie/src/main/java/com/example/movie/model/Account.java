package com.example.movie.model;
import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameAccount;
    private String password;
    @OneToOne
    private Role role;

    public Account() {
    }



    public Account(Long id, String nameAccount, String password, Role role) {
        this.id = id;
        this.nameAccount = nameAccount;
        this.password = password;
        this.role = role;
    }

    public Account(String email, String password, Role role) {
        this.nameAccount = email;
        this.password = password;
        this.role = role;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }
}
