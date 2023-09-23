package com.example.movie.service;

import com.example.movie.model.PackedMovie;

import java.util.List;

public interface IPackedMovieService {
    PackedMovie findPackedById(Long id);
    List<PackedMovie> getAllListTypeAccount();
    PackedMovie findByPrice(Double price);


}
