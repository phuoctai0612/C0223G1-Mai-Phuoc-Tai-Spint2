package com.example.movie.service;

import com.example.movie.model.Actor;
import com.example.movie.model.Author;
import com.example.movie.model.Category;
import com.example.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMovieService {
    List<Movie> getAllByTimePostOrderByTimePostDescLimit10();
    Movie findMovieById(Long id);
    void createMovie(Movie movie);
    List<Movie> findFirst6ByCategoriesContaining(String category);
    Page<Movie> getListSearch(Pageable pageable, String typeSearch, String nation, List<Category> category, String yearStart);
    Page<Movie> getListSearchCategory(Pageable pageable, String typeSearch, String nation, List<Category> category,List<Category> category1, String yearStart);
    Page<Movie> getListSearchAuthor(Pageable pageable, String typeSearch, List<Author> authors, List<Category> category, String nation, String yearStart);
    Page<Movie> getListSearchActor(Pageable pageable, String typeSearch, List<Actor> authors, List<Category> category, String nation, String yearStart);
    List<Movie> getListTopView();
    List<Movie> getListPropose();
    Page<Movie> getListSearchNameMovie(Pageable pageable, String typeSearch,List<Category> category, String nation, String yearStart,String name);
    void increaseViewMovie(Movie movie);
}
