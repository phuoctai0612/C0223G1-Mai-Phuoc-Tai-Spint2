package com.example.movie.repository;

import com.example.movie.model.Account;
import com.example.movie.model.Author;
import com.example.movie.model.Category;
import com.example.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
    // Page Search chung
    List<Movie> findFirst6ByOrderByTimePostDesc();

    Page<Movie> findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePost(Pageable pageable, List<Category> category, String nation, String yearStart);

    Page<Movie> findByCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByTimePost(Pageable pageable, String category, String nation, String yearStart);

    Page<Movie> findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(Pageable pageable, List<Category> category, String nation, String yearStart);

    Page<Movie> findByCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByNameDesc(Pageable pageable, String category, String nation, String yearStart);

    Page<Movie> findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(Pageable pageable, List<Category> category, String nation, String yearStart);

    Page<Movie> findByCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(Pageable pageable, String category, String nation, String yearStart);

    Page<Movie> findByCategoriesInAndNation_NameContainingAndYearStartContaining(Pageable pageable, List<Category> category, String nation, String yearStart);

    Page<Movie> findByCategories_NameContainingAndNation_NameContainingAndYearStartContaining(Pageable pageable, String category, String nation, String yearStart);

    // List search author
    Page<Movie> findByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePost(Pageable pageable, List<Author> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findByAuthorsInAndCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByTimePost(Pageable pageable,List<Author> list, String category, String nation, String yearStart);

    Page<Movie>findByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(Pageable pageable, List<Author> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findByAuthorsInAndCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByNameDesc(Pageable pageable, List<Author> authors, String category, String nation, String yearStart);

    Page<Movie> findByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(Pageable pageable, List<Author> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findByAuthorsInAndCategories_NameContainingAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(Pageable pageable, List<Author> authors, String category, String nation, String yearStart);

    Page<Movie> findByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContaining(Pageable pageable, List<Author> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findByAuthorsInAndNation_NameContainingAndYearStartContaining(Pageable pageable, List<Author> authors, String category, String nation, String yearStart);

    Movie findAllById(Long id);
}
