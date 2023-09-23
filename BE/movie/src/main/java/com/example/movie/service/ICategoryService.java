package com.example.movie.service;

import com.example.movie.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getListCategory();
    Category findCategoryById(Long id);

}
