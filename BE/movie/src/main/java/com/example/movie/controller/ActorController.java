package com.example.movie.controller;

import com.example.movie.model.Actor;
import com.example.movie.model.Category;
import com.example.movie.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private IActorService actorService;
    @GetMapping("/getActor/{id}")
    public ResponseEntity<Actor> getCategory(@PathVariable("id")Long id){
        return new ResponseEntity<>(actorService.getActor(id), HttpStatus.OK) ;
    }
}
