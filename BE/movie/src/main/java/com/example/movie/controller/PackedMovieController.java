package com.example.movie.controller;

import com.example.movie.model.Account;
import com.example.movie.model.History;
import com.example.movie.model.PackedMovie;
import com.example.movie.service.IAccountService;
import com.example.movie.service.IHistoryService;
import com.example.movie.service.IPackedMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("packedMovie")
@CrossOrigin("*")
public class PackedMovieController {
    @Autowired
    private IPackedMovieService typeAccountService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IPackedMovieService packedMovieService;
    @Autowired
    private IHistoryService historyService;

    @GetMapping("")
    public ResponseEntity<List<PackedMovie>> getListTypeAccount() {
        return new ResponseEntity<>(typeAccountService.getAllListTypeAccount(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addHistoryPaymentAccount(@RequestParam("email") String email, @RequestParam("price") Double price) {
        Account account = accountService.findByEmail(email);
        PackedMovie packedMovie = packedMovieService.findByPrice(price/100);
        LocalDateTime startMovie = LocalDateTime.now();

        LocalDateTime endMovie = null;
        if (packedMovie.getId() == 1) {
            endMovie = startMovie.plusMonths(6);
        } else if (packedMovie.getId() == 2) {
            endMovie = startMovie.plusMonths(3);
        } else if (packedMovie.getId() == 3) {
            endMovie = startMovie.plusMonths(1);
        }
        String dayStart=startMovie.toString().substring(0,10)+" "+startMovie.toString().substring(11,16);
        String dayEnd=endMovie.toString().substring(0,10)+" "+endMovie.toString().substring(11,16);
        History history = new History(dayStart,dayEnd,true,account,packedMovie);
        historyService.createHistory(history);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
