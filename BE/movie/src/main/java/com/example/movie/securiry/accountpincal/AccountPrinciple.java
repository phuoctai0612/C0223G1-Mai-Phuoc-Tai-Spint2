package com.example.movie.securiry.accountpincal;

import com.example.movie.model.Account;
import com.example.movie.model.Customer;
import com.example.movie.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountPrinciple implements UserDetails {
    private Long id;

    private String nameAccount;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    public AccountPrinciple() {
    }

    public AccountPrinciple(Long id, String nameAccount, String password, Collection<? extends GrantedAuthority> role) {
        this.id = id;
        this.nameAccount = nameAccount;
        this.password = password;
        this.role = role;
    }
 public static AccountPrinciple build(Account account){
     List<GrantedAuthority> authorities= new ArrayList<>();
     authorities.add(new SimpleGrantedAuthority(account.getRole().getName()));
     return new AccountPrinciple(
             account.getId(),
             account.getNameAccount(),
             account.getPassword(),
             authorities
     );

 }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nameAccount;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
