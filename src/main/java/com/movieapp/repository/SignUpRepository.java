package com.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapp.models.User;

public interface SignUpRepository extends JpaRepository<User,Long> {

}
