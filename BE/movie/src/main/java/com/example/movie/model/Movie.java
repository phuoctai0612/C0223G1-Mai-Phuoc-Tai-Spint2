package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String timeEndMovie;
    private boolean statusMovie;
    private String yearStart;
    @OneToOne
    private Nation nation;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_categorys", joinColumns = @JoinColumn(name = "id_movie"), inverseJoinColumns = @JoinColumn(name = "id_categorys"))
    @JsonManagedReference
    private List<Category> categories;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_authors", joinColumns = @JoinColumn(name = "id_movie"), inverseJoinColumns = @JoinColumn(name = "id_authors"))
    @JsonManagedReference
    private List<Author> authors;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_actors", joinColumns = @JoinColumn(name = "id_movie"), inverseJoinColumns = @JoinColumn(name = "id_actors"))
    @JsonManagedReference
    private List<Actor> actors;

    public Movie() {
    }

    public Movie(Long id, String name, String timeEndMovie, boolean statusMovie, String yearStart, Nation nation, List<Category> categories, List<Author> authors, List<Actor> actors) {
        this.id = id;
        this.name = name;
        this.timeEndMovie = timeEndMovie;
        this.statusMovie = statusMovie;
        this.yearStart = yearStart;
        this.nation = nation;
        this.categories = categories;
        this.authors = authors;
        this.actors = actors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeEndMovie() {
        return timeEndMovie;
    }

    public void setTimeEndMovie(String timeEndMovie) {
        this.timeEndMovie = timeEndMovie;
    }

    public boolean isStatusMovie() {
        return statusMovie;
    }

    public void setStatusMovie(boolean statusMovie) {
        this.statusMovie = statusMovie;
    }

    public String getYearStart() {
        return yearStart;
    }

    public void setYearStart(String yearStart) {
        this.yearStart = yearStart;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
