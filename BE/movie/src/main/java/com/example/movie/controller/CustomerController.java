package com.example.movie.controller;

import com.example.movie.model.Account;
import com.example.movie.service.IAccountService;
import com.example.movie.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/customers")

public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IAccountService accountService;

//    @GetMapping("")
//    public ResponseEntity<?> login(@RequestParam("email")String email, @RequestParam("password")String password){
////        Account account=accountService.loginAccount(email);
////        if (account!=null&&account.getPassword().equals(password)){
////            return new ResponseEntity<>(account, HttpStatus.OK);
////        }else {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////    }
}
