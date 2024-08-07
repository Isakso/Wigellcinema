package com.example.wigellcinema.service;

import com.example.wigellcinema.exceptions.ResourceNotFoundException;
import com.example.wigellcinema.models.Movies;
import com.example.wigellcinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService implements MovieServiceInterface{

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movies addMovie(Movies movie) {
        if(!movieRepository.findAll().contains(movie)){
          return  movieRepository.save(movie);

        }
        throw new ResourceNotFoundException("Movie","with title", movie);
    }

    @Override
    public void deleteMovie(int id) {
        Optional<Movies> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movies movie = optionalMovie.get();
            movieRepository.delete(movie);
        } else {
            throw new ResourceNotFoundException("Movie", "with id", id + " could not be found");
        }
    }

    @Override
    public Movies UpdateMovie(int id, Movies updatedMovie) {

        if(movieRepository.existsById(id)){
            Movies currentMovie = movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie","with_id", id +"Could not be updated"));
            currentMovie.setMovieLength(updatedMovie.getMovieLength());
            currentMovie.setMovieTitle(updatedMovie.getMovieTitle());
            currentMovie.setGenre(updatedMovie.getMovieTitle());
            currentMovie.setAgeLimit(updatedMovie.getAgeLimit());
            return movieRepository.save(currentMovie);
        }
        throw new ResourceNotFoundException("CurrentMovie", "with", id + "Could not be saved");


    }
}
