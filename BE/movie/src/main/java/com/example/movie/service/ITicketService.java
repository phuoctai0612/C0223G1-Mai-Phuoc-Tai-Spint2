package com.example.movie.service;

import com.example.movie.model.Account;
import com.example.movie.model.Movie;
import com.example.movie.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketService {
    void addFavouriteCustomer(Account account, Movie movie);
    void deleteFavouriteCustomer(Account account, Movie movie);
    Ticket findByAccountAndMovie(Account account, Movie movie);
    Page<Ticket> findByAccount(Pageable pageable, Account account);

}
