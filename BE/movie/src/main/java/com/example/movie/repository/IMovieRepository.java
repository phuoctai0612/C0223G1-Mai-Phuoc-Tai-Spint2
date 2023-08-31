package com.example.movie.repository;

import com.example.movie.model.Account;
import com.example.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie,Long> {
}
