package com.example.movie.controller;

import com.example.movie.model.Account;
import com.example.movie.model.Movie;
import com.example.movie.service.IAccountService;
import com.example.movie.service.IMovieService;
import com.example.movie.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/tickets")

public class TicketController {
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private IMovieService movieService;
    @Autowired
    private IAccountService accountService;

    @PostMapping("")
    public void addMovieInFavourite(@RequestParam("idMovie") Long idMovie, @RequestParam("nameAccount") String nameAccount) {
        Movie movie = movieService.findMovieById(idMovie);
        Account account = accountService.findByEmail(nameAccount);
        ticketService.addFavouriteCustomer(account, movie);
    }
     @GetMapping("/findMovie")
    public ResponseEntity<?> findMovieOfAccount(@RequestParam("idMovie") Long idMovie, @RequestParam("nameAccount") String nameAccount) {
        Movie movie = movieService.findMovieById(idMovie);
        Account account = accountService.findByEmail(nameAccount);
       return new ResponseEntity<>(ticketService.findByAccountAndMovie(account,movie), HttpStatus.OK) ;
    }
   @DeleteMapping("")
    public void deleteMovieOfAccount(@RequestParam("idMovie") Long idMovie, @RequestParam("nameAccount") String nameAccount){
       Movie movie = movieService.findMovieById(idMovie);
       Account account = accountService.findByEmail(nameAccount);
       ticketService.deleteFavouriteCustomer(account,movie);
   }
   @GetMapping("/getListFavourite")
    public ResponseEntity<?> getListFavourite(@PageableDefault(size = 16) Pageable pageable, @RequestParam("nameAccount")String nameAccount){
        Account account=accountService.findByEmail(nameAccount);
        return new ResponseEntity<>(ticketService.findByAccount(pageable,account),HttpStatus.OK);
   }
}
