package com.example.movie.service;

import com.example.movie.model.Nation;

import java.util.List;

public interface INationService {
    List<Nation> listNation();
    Nation findNationById(Long id);
}
