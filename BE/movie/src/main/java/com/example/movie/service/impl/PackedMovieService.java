package com.example.movie.service.impl;

import com.example.movie.model.PackedMovie;
import com.example.movie.repository.IPackedMovieRepository;
import com.example.movie.service.IPackedMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackedMovieService implements IPackedMovieService {
    @Autowired
    private IPackedMovieRepository typeAccountRepository;
    @Override
    public PackedMovie findPackedById(Long id) {
        return typeAccountRepository.findById(id).get();
    }

    @Override
    public List<PackedMovie> getAllListTypeAccount() {
        return typeAccountRepository.findAll();
    }

    @Override
    public PackedMovie findByPrice(Double price) {
        return typeAccountRepository.findByPrice(price);
    }
}
