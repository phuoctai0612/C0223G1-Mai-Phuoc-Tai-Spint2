package com.example.movie.service.impl;

import com.example.movie.model.Account;
import com.example.movie.model.Movie;
import com.example.movie.model.Ticket;
import com.example.movie.repository.ITicketRepository;
import com.example.movie.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;
    @Override
    public void addFavouriteCustomer(Account account, Movie movie) {
        Ticket ticket=new Ticket();
        ticket.setMovie(movie);
        ticket.setAccount(account);
        ticketRepository.save(ticket);
    }

    @Override
    public void deleteFavouriteCustomer(Account account, Movie movie) {
       Ticket ticket = findByAccountAndMovie(account,movie);
        ticketRepository.delete(ticket);
    }

    @Override
    public Ticket findByAccountAndMovie(Account account, Movie movie) {

        return ticketRepository.findByAccountAndMovie(account,movie);
    }

    @Override
    public Page<Ticket> findByAccount(Pageable pageable, Account account) {
        return ticketRepository.findByAccount(pageable,account);
    }
}
