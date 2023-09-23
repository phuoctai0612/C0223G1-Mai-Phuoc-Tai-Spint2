package com.example.movie.service.impl;

import com.example.movie.model.Actor;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

public class MovieService implements IMovieService {
    @Autowired
    private IMovieRepository movieRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Movie> getAllByTimePostOrderByTimePostDescLimit10() {
        return movieRepository.findFirst20ByOrderByTimePostDesc();
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
            if (movieList.size() == 8) {
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
                if (category.size() != 0) {
                    return movieRepository.findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePostDesc(pageable, category, nation, yearStart);
                } else {
                    return movieRepository.findByNation_NameContainingAndYearStartContainingOrderByTimePostDesc(pageable, nation, yearStart);
                }
            case "2":
                if (category.size() != 0) {
                    return movieRepository.findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(pageable, category, nation, yearStart);
                } else {
                    return movieRepository.findByNation_NameContainingAndYearStartContainingOrderByNameDesc(pageable, nation, yearStart);
                }
            case "3":
                if (category.size() != 0) {
                    return movieRepository.findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(pageable, category, nation, yearStart);
                } else {
                    return movieRepository.findByNation_NameContainingAndYearStartContainingOrderByYearStartDesc(pageable, nation, yearStart);
                }
            default:
                if (category.size() != 0) {
                    return movieRepository.findByCategoriesInAndNation_NameContainingAndYearStartContaining(pageable, category, nation, yearStart);
                } else {
                    return movieRepository.findByNation_NameContainingAndYearStartContaining(pageable, nation, yearStart);
                }
        }
    }

    @Override
    public Page<Movie> getListSearchCategory(Pageable pageable, String typeSearch, String nation, List<Category> category, List<Category> category1, String yearStart) {
        switch (typeSearch) {
            case "1":
                return movieRepository.findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePostDesc(pageable, category1, nation, yearStart);
            case "2":
                return movieRepository.findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(pageable, category1, nation, yearStart);
            case "3":
                return movieRepository.findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(pageable, category1, nation, yearStart);
            default:
                return movieRepository.findDistinctByCategoriesIsInAndNation_NameContainingAndYearStartContaining(pageable, category1, nation, yearStart);
        }
    }

    @Override
    public Page<Movie> getListSearchAuthor(Pageable pageable, String typeSearch, List<Author> authors, List<Category> category, String nation, String yearStart) {
        switch (typeSearch) {
            case "1":
                if (category.size() != 0) {
                    return movieRepository.findDistinctByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePostDesc(pageable, authors, category, nation, yearStart);
                } else {
                    return movieRepository.findDistinctByAuthorsInAndNation_NameContainingAndYearStartContainingOrderByTimePostDesc(pageable, authors, nation, yearStart);
                }

            case "2":
                if (category.size() != 0) {
                    return movieRepository.findDistinctByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(pageable, authors, category, nation, yearStart);
                } else {
                    return movieRepository.findDistinctByAuthorsInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(pageable, authors, nation, yearStart);
                }
            case "3":
                if (category.size() != 0) {
                    return movieRepository.findDistinctByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(pageable, authors, category, nation, yearStart);

                } else {
                    return movieRepository.findDistinctByAuthorsInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(pageable, authors, nation, yearStart);
                }
            default:
                if (category.size() != 0) {
                    return movieRepository.findDistinctByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContaining(pageable, authors, category, nation, yearStart);
                } else {
                    return movieRepository.findDistinctByAuthorsInAndNation_NameContainingAndYearStartContaining(pageable, authors, nation, yearStart);
                }
        }
    }

    @Override
    public Page<Movie> getListSearchActor(Pageable pageable, String typeSearch, List<Actor> actors, List<Category> category, String nation, String yearStart) {
        switch (typeSearch) {
            case "1":
                if (category.size() != 0) {
                    return movieRepository.findDistinctByActorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePost(pageable, actors, category, nation, yearStart);
                } else {
                    return movieRepository.findDistinctByActorsInAndNation_NameContainingAndYearStartContainingOrderByTimePostDesc(pageable, actors, nation, yearStart);
                }

            case "2":
                if (category.size() != 0) {
                    return movieRepository.findDistinctByActorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(pageable, actors, category, nation, yearStart);
                } else {
                    return movieRepository.findDistinctByActorsInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(pageable, actors, nation, yearStart);
                }
            case "3":
                if (category.size() != 0) {
                    return movieRepository.findDistinctByActorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(pageable, actors, category, nation, yearStart);
                } else {
                    return movieRepository.findDistinctByActorsInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(pageable, actors, nation, yearStart);
                }
            default:
                if (category.size() != 0) {
                    return movieRepository.findDistinctByActorsInAndCategoriesInAndNation_NameContainingAndYearStartContaining(pageable, actors, category, nation, yearStart);
                } else {
                    return movieRepository.findDistinctByActorsInAndNation_NameContainingAndYearStartContaining(pageable, actors, nation, yearStart);
                }
        }
    }

    @Override
    public List<Movie> getListTopView() {
        return movieRepository.findFirst10ByOrderByViewDesc();
    }

    @Override
    public List<Movie> getListPropose() {
        Set<Movie> movieList = new HashSet<>();
        List<Movie> movies = new ArrayList<>();
        int checkLength = movieRepository.findAll().size();
        Long movie = 0L;
        while (movieList.size() < 15 && movie < checkLength) {
            movie = (long) Math.floor(Math.random() * checkLength);
            if (movie > 0) {
                movieList.add(movieRepository.findById(movie).get());
            }
        }
        movies.addAll(movieList);
        System.out.println(movies);
        return movies;
    }

    @Override
    public Page<Movie> getListSearchNameMovie(Pageable pageable,String typeSearch, List<Category> category, String nation, String yearStart, String name) {
        switch (typeSearch) {
            case "1":
                if (category.size() != 0) {
                    return movieRepository.findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingAndNameContainingOrderByTimePostDesc(pageable, category, nation, yearStart,name);
                } else {
                    return movieRepository.findDistinctByNation_NameContainingAndYearStartContainingAndNameContainingOrderByTimePostDesc(pageable, nation, yearStart,name);
                }
            case "2":
                if (category.size() != 0) {
                    return movieRepository.findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingAndNameContainingOrderByNameDesc(pageable, category, nation, yearStart,name);
                } else {
                    return movieRepository.findDistinctByNation_NameContainingAndYearStartContainingAndNameContainingOrderByNameDesc(pageable, nation, yearStart,name);
                }
            case "3":
                if (category.size() != 0) {
                    return movieRepository.findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingAndNameContainingOrderByYearStartDesc(pageable, category, nation, yearStart,name);
                } else {
                    return movieRepository.findDistinctByNation_NameContainingAndYearStartContainingAndNameContainingOrderByYearStartDesc(pageable, nation, yearStart,name);
                }
            default:
                if (category.size() != 0) {
                    return movieRepository.findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingAndNameContaining(pageable, category, nation, yearStart,name);
                } else {
                    return movieRepository.findDistinctByNation_NameContainingAndYearStartContainingAndNameContaining(pageable, nation, yearStart,name);
                }
        }
    }

    @Override
    public void increaseViewMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
