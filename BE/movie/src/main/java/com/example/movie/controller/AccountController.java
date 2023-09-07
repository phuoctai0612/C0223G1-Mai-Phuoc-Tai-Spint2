package com.example.movie.controller;

import com.example.movie.dto.response.JwtResponse;
import com.example.movie.model.Account;
import com.example.movie.model.Customer;
import com.example.movie.model.Role;
import com.example.movie.securiry.accountpincal.AccountPrinciple;
import com.example.movie.securiry.jwt.JwtProvider;
import com.example.movie.service.IAccountService;
import com.example.movie.service.ICustomerService;
import com.example.movie.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("")
    public ResponseEntity<?> createAccount(@RequestParam("email") String email, @RequestParam("password") String password) {

        Role role = roleService.findRoleById(1L);
        String encoderNewPassword = passwordEncoder.encode(password);
        Account account = new Account(email, encoderNewPassword, role);
        accountService.createAccount(account);
        Customer customer = new Customer(account.getNameAccount(), account);
        customerService.createCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String password) {

        Account account = accountService.findByEmail(email);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean passwordsMatch = passwordEncoder.matches(password, account.getPassword());
        if (account != null && passwordsMatch) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtProvider.createToken(authentication);
            AccountPrinciple userPrinciple = (AccountPrinciple) authentication.getPrincipal();
            return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getUsername(), userPrinciple.getAuthorities()));
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



    }
@GetMapping("/token/{token}")
public ResponseEntity<?> getAccountWithToken(@PathVariable String token){
        return new ResponseEntity<>(jwtProvider.getUserNameToken(token),HttpStatus.OK);
}
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @GetMapping("/aa")
    public ResponseEntity<?> aa() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
