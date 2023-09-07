package com.example.movie.controller;

import com.example.movie.model.Category;
import com.example.movie.model.Nation;
import com.example.movie.service.ICategoryService;
import com.example.movie.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/nations")
public class NationController {
    @Autowired
    private INationService nationService;
    @GetMapping("")
    public ResponseEntity<List<Nation>> getListNation(){
       return new ResponseEntity<>(nationService.listNation(), HttpStatus.OK) ;
    }
}
