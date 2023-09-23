package com.example.movie.repository;

import com.example.movie.model.PackedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPackedMovieRepository extends JpaRepository<PackedMovie,Long> {
    PackedMovie findByPrice(Double price);
}
