package com.example.movie.service.impl;

import com.example.movie.model.Author;
import com.example.movie.model.Category;
import com.example.movie.model.Movie;
import com.example.movie.repository.ICategoryRepository;
import com.example.movie.repository.IMovieRepository;
import com.example.movie.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class MovieService implements IMovieService {
    @Autowired
    private IMovieRepository movieRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Movie> getAllByTimePostOrderByTimePostDescLimit10() {
        return movieRepository.findFirst6ByOrderByTimePostDesc();
    }

    @Override
    public Movie findMovieById(Long id) {
        return movieRepository.findAllById(id);
    }

    @Override
    public void createMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findFirst6ByCategoriesContaining(String category) {
        List<Movie> movieList = new ArrayList<>();
        Category category1 = categoryRepository.findFirstByNameContaining(category);

        for (Movie movie : movieRepository.findAll()) {
            if (movieList.size() == 6) {
                break;
            }
            if (movie.getCategories().contains(category1)) {
                movieList.add(movie);

            }
        }
        return movieList;
    }

    @Override
    public Page<Movie> getListSearch(Pageable pageable, String typeSearch, String nation, List<Category> category, String yearStart) {

        switch (typeSearch) {
            case "1":
                if (category.size()!=0){
                    return movieRepository.findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePost(pageable, category,nation,yearStart);
                }else {
                    return movieRepository.findByCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByTimePost(pageable,"", nation,yearStart);
                }

            case "2":
                if (category.size()!=0) {
                    return movieRepository.findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(pageable, category,nation,yearStart);
                }else {
                    return movieRepository.findByCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByNameDesc(pageable,"",nation,yearStart);

                }

            case "3":
                if (category.size()!=0) {
                    return movieRepository.findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(pageable, category,nation,yearStart);

                }else {
                    return movieRepository.findByCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(pageable,"",nation,yearStart);

                }
            default:
                if (category.size()!=0) {
                    return movieRepository.findByCategoriesInAndNation_NameContainingAndYearStartContaining(pageable, category,nation,yearStart);
                }else {
                    return movieRepository.findByCategories_NameContainingAndNation_NameContainingAndYearStartContaining(pageable,"",nation,yearStart);

                }

        }

    }

    @Override
    public Page<Movie> getListSearchAuthor(Pageable pageable, String typeSearch, List<Author> authors, List<Category> category, String nation, String yearStart) {
        switch (typeSearch) {
            case "1":
                if (category.size()!=0){
                    return movieRepository.findByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePost(pageable,authors, category,nation,yearStart);
                }else {
                    return movieRepository.findByAuthorsInAndCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByTimePost(pageable,authors, "",nation,yearStart);
                }

            case "2":
                if (category.size()!=0) {
                    return movieRepository.findByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(pageable,authors, category,nation,yearStart);
                }else {
                    return movieRepository.findByAuthorsInAndCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByNameDesc(pageable,authors, "",nation,yearStart);
                }
            case "3":
                if (category.size()!=0) {
                    return movieRepository.findByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(pageable,authors, category,nation,yearStart);

                }else {
                    return movieRepository.findByAuthorsInAndCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(pageable,authors, "",nation,yearStart);
                }
            default:
                if (category.size()!=0) {
                    return movieRepository.findByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContaining(pageable,authors, category,nation,yearStart);
                }else {
                    return movieRepository.findByAuthorsInAndNation_NameContainingAndYearStartContaining(pageable,authors, "",nation,yearStart);
                }
        }
    }
}
