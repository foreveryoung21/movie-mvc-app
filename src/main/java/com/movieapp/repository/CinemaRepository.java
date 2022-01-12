package com.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapp.models.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {

}
