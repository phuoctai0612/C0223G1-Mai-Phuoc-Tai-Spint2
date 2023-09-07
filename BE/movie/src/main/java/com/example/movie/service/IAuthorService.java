package com.example.movie.service;

import com.example.movie.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAuthorById(Long id);

}
