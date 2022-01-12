package com.movieapp.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieapp.models.Cinema;
import com.movieapp.repository.CinemaRepository;
import com.movieapp.services.CinemaService;


@Transactional
@Service
public class CinemaImpl implements CinemaService {

	
	@Autowired
	private CinemaRepository cinemaRepository;
	
	@Override
	public void saveCinema(Cinema cinema) {
		this.cinemaRepository.saveAndFlush(cinema);
	}

	@Override
	public List<Cinema> getAllCinema() {
		// TODO Auto-generated method stub
		return cinemaRepository.findAll();
	}

	@Override
	public Cinema getCinemaId(long id) {
		Optional<Cinema>optional = cinemaRepository.findById(id);
		Cinema cinema=null;
		if(optional.isPresent()) {
			cinema = optional.get();
		}else {
			throw new RuntimeException("Employee not found for id::" +id);
		}
		return cinema;
	}

	@Override
	public void deleteCinemaId(long id) {
		this.cinemaRepository.deleteById(id);
		
	}
	
	

}
