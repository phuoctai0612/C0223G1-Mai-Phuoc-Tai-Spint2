package com.example.movie.repository;

import com.example.movie.model.Account;
import com.example.movie.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepository extends JpaRepository<Ticket,Long> {
}
