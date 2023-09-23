package com.example.movie.repository;

import com.example.movie.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor,Long> {
List<Actor> getActorById(Long id);

}
