package com.example.movie.controller;

import com.example.movie.model.Category;
import com.example.movie.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin("*")
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<List<Category>> getListCategory(){
        return new ResponseEntity<>(categoryService.getListCategory(), HttpStatus.OK) ;
    }
       @GetMapping("/getCategory/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id")Long id){
        return new ResponseEntity<>(categoryService.findCategoryById(id), HttpStatus.OK) ;
    }

}
