package com.movieapp.services;

import java.util.List;

import com.movieapp.models.Movie;

public interface MovieService {
void saveMovie(Movie movie);
void saveMovieId(Movie movie,long id);
List<Movie> getAllMovies();
Movie getMovieId(long id);
void deleteMovieId(long id);


}
