package com.example.movie.service.impl;

import com.example.movie.model.Category;
import com.example.movie.repository.ICategoryRepository;
import com.example.movie.service.ICategoryService;
import com.example.movie.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> getListCategory() {
        return categoryRepository.findAll();
    }
}
