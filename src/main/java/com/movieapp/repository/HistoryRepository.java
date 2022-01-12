package com.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieapp.models.History;

@Repository
public interface HistoryRepository extends JpaRepository<History,Long> {

}
