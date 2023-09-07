package com.example.movie.service.impl;

import com.example.movie.model.Nation;
import com.example.movie.repository.INationRepository;
import com.example.movie.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NationService implements INationService {
    @Autowired
    private INationRepository nationRepository;
    @Override
    public List<Nation> listNation() {
        return nationRepository.findAll();
    }
}
