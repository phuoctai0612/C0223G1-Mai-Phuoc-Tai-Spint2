package com.example.movie.controller;

import com.example.movie.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;
    @GetMapping("/getAuthor/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable("id") Long id){
        return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
    }
}
