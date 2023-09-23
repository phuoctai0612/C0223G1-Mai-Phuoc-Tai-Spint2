package com.example.movie.service;

import com.example.movie.model.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> getActorById(Long id);
 Actor getActor(Long id);
}
