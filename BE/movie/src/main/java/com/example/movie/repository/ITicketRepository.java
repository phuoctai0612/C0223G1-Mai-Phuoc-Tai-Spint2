package com.example.movie.repository;

import com.example.movie.model.Account;
import com.example.movie.model.Movie;
import com.example.movie.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITicketRepository extends JpaRepository<Ticket,Long> {
   Ticket findByAccountAndMovie(Account account, Movie movie);

   Page<Ticket> findByAccount(Pageable pageable,Account account);
}
