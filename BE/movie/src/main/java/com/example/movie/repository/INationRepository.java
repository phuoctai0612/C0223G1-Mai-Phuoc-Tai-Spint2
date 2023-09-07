package com.example.movie.repository;

import com.example.movie.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INationRepository extends JpaRepository<Nation,Long> {

}
