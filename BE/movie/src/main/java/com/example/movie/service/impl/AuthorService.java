package com.example.movie.service.impl;

import com.example.movie.model.Author;
import com.example.movie.repository.IAuthorRepository;
import com.example.movie.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository repository;
    @Override
    public List<Author> getAuthorById(Long id) {
        return repository.getAuthorById(id);
    }
}
