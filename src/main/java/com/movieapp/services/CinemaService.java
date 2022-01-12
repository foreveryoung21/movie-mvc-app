package com.movieapp.services;

import java.util.List;

import com.movieapp.models.Cinema;

public interface CinemaService {
	void saveCinema(Cinema cinema);
	List<Cinema> getAllCinema();
	Cinema getCinemaId(long id);
	void deleteCinemaId(long id);
	
	
}

