package com.movieapp.services;

import com.movieapp.models.History;
import com.movieapp.models.Movie;

public interface UserService {
	void saveUserMovie(Movie movie);
	void saveUserHistory(History history);

}
