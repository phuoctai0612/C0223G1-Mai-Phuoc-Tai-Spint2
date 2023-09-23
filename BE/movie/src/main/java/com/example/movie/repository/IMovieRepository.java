package com.example.movie.repository;

import com.example.movie.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
    // Page Search chung
    Movie findAllById(Long id);

    List<Movie> findFirst10ByOrderByViewDesc();

    List<Movie> findFirst20ByOrderByTimePostDesc();

    /**
     * Sidebar Movie Trending
     */


    Page<Movie> findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePostDesc(Pageable pageable, List<Category> category, String nation, String yearStart);

    Page<Movie> findByNation_NameContainingAndYearStartContainingOrderByTimePostDesc(Pageable pageable, String nation, String yearStart);

    Page<Movie> findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(Pageable pageable, List<Category> category, String nation, String yearStart);

    Page<Movie> findByNation_NameContainingAndYearStartContainingOrderByNameDesc(Pageable pageable, String nation, String yearStart);

    Page<Movie> findByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(Pageable pageable, List<Category> category, String nation, String yearStart);

    Page<Movie> findByNation_NameContainingAndYearStartContainingOrderByYearStartDesc(Pageable pageable, String nation, String yearStart);

    Page<Movie> findByCategoriesInAndNation_NameContainingAndYearStartContaining(Pageable pageable, List<Category> category, String nation, String yearStart);

    Page<Movie> findByNation_NameContainingAndYearStartContaining(Pageable pageable, String nation, String yearStart);

    /**
     * List Search Author
     *
     * @param pageable
     * @param authors
     * @param category
     * @param nation
     * @param yearStart
     * @return
     */
    // List search author
    Page<Movie> findDistinctByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePostDesc(Pageable pageable, List<Author> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findDistinctByAuthorsInAndNation_NameContainingAndYearStartContainingOrderByTimePostDesc(Pageable pageable, List<Author> list, String nation, String yearStart);

    Page<Movie> findDistinctByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(Pageable pageable, List<Author> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findDistinctByAuthorsInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(Pageable pageable, List<Author> authors, String nation, String yearStart);

    Page<Movie> findDistinctByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(Pageable pageable, List<Author> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findDistinctByAuthorsInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(Pageable pageable, List<Author> authors, String nation, String yearStart);

    Page<Movie> findDistinctByAuthorsInAndCategoriesInAndNation_NameContainingAndYearStartContaining(Pageable pageable, List<Author> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findDistinctByAuthorsInAndNation_NameContainingAndYearStartContaining(Pageable pageable, List<Author> authors, String nation, String yearStart);
// List Actor

    /**
     * List Search Actor
     *
     * @param pageable
     * @param authors
     * @param category
     * @param nation
     * @param yearStart
     * @return
     */
    Page<Movie> findDistinctByActorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePost(Pageable pageable, List<Actor> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findDistinctByActorsInAndNation_NameContainingAndYearStartContainingOrderByTimePostDesc(Pageable pageable, List<Actor> list, String nation, String yearStart);

    Page<Movie> findDistinctByActorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(Pageable pageable, List<Actor> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findDistinctByActorsInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(Pageable pageable, List<Actor> authors, String nation, String yearStart);

    Page<Movie> findDistinctByActorsInAndCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(Pageable pageable, List<Actor> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findDistinctByActorsInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(Pageable pageable, List<Actor> authors, String nation, String yearStart);

    Page<Movie> findDistinctByActorsInAndCategoriesInAndNation_NameContainingAndYearStartContaining(Pageable pageable, List<Actor> authors, List<Category> category, String nation, String yearStart);

    Page<Movie> findDistinctByActorsInAndNation_NameContainingAndYearStartContaining(Pageable pageable, List<Actor> authors, String nation, String yearStart);

    /**
     * List search double category
     *
     * @param pageable
     * @param nation
     * @param yearStart
     * @return
     */


    Page<Movie> findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByTimePostDesc(Pageable pageable, List<Category> category1, String nation, String yearStart);

    Page<Movie> findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByNameDesc(Pageable pageable, List<Category> category1, String nation, String yearStart);

    Page<Movie> findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingOrderByYearStartDesc(Pageable pageable, List<Category> category1, String nation, String yearStart);

    Page<Movie> findDistinctByCategoriesIsInAndNation_NameContainingAndYearStartContaining(Pageable pageable, List<Category> category1, String nation, String yearStart);

    /**
     *
     * @param pageable
     * @param category
     * @param nation
     * @param yearStart
     * @return
     */
    Page<Movie> findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingAndNameContainingOrderByTimePostDesc(Pageable pageable, List<Category> category, String nation, String yearStart,String name);

    Page<Movie> findDistinctByNation_NameContainingAndYearStartContainingAndNameContainingOrderByTimePostDesc(Pageable pageable, String nation, String yearStart,String name);

    Page<Movie> findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingAndNameContainingOrderByNameDesc(Pageable pageable, List<Category> category, String nation, String yearStart,String name);

    Page<Movie> findDistinctByNation_NameContainingAndYearStartContainingAndNameContainingOrderByNameDesc(Pageable pageable, String nation, String yearStart,String name);

    Page<Movie> findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingAndNameContainingOrderByYearStartDesc(Pageable pageable, List<Category> category, String nation, String yearStart,String name);

    Page<Movie> findDistinctByNation_NameContainingAndYearStartContainingAndNameContainingOrderByYearStartDesc(Pageable pageable, String nation, String yearStart,String name);

    Page<Movie> findDistinctByCategoriesInAndNation_NameContainingAndYearStartContainingAndNameContaining(Pageable pageable, List<Category> category, String nation, String yearStart,String name);

    Page<Movie> findDistinctByNation_NameContainingAndYearStartContainingAndNameContaining(Pageable pageable, String nation, String yearStart,String name);

//    /**
//     * List search Nation
//     *
//     * @param pageable
//     * @param category1
//     * @param nation
//     * @param yearStart
//     * @return
//     */
//    Page<Movie> findDistinctByCategoriesInAndNationInAndYearStartContainingOrderByTimePostDesc(Pageable pageable, List<Category> category1, List<Nation> nation, String yearStart);
//
//    Page<Movie> findDistinctByCategoriesInAndNationInAndYearStartContainingOrderByNameDesc(Pageable pageable, List<Category> category1, List<Nation> nation, String yearStart);
//
//    Page<Movie> findDistinctByCategoriesInAndNationInAndYearStartContainingOrderByYearStartDesc(Pageable pageable, List<Category> category1, List<Nation> nation, String yearStart);
//
//    Page<Movie> findDistinctByCategoriesIsInAndNationInAndYearStartContaining(Pageable pageable, List<Category> category1, List<Nation> nation, String yearStart);


}
