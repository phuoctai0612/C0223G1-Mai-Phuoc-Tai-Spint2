package com.example.movie.service.impl;

import com.example.movie.model.Actor;
import com.example.movie.repository.IActorRepository;
import com.example.movie.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActorService implements IActorService {
    @Autowired
    private IActorRepository actorRepository;
    @Override
    public List<Actor> getActorById(Long id) {
        return actorRepository.getActorById(id);
    }

    @Override
    public Actor getActor(Long id) {
        return actorRepository.findById(id).get();
    }
}
