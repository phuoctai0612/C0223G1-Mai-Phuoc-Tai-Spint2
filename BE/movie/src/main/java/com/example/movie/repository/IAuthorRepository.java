package com.example.movie.repository;

import com.example.movie.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAuthorRepository extends JpaRepository<Author,Long> {
    List<Author> getAuthorById(Long id);
}
