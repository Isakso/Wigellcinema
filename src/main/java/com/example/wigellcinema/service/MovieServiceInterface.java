package com.example.wigellcinema.service;

import com.example.wigellcinema.models.Movies;

import java.util.List;

public interface MovieServiceInterface {

    List<Movies> getAllMovies();
    Movies addMovie(Movies movie);
    void deleteMovie(int id);
    Movies UpdateMovie(int id, Movies movie);


}
