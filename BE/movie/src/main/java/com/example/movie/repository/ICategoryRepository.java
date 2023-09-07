package com.example.movie.repository;

import com.example.movie.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    Category findFirstByNameContaining(String name);
}
