package com.example.Project.WatchlistApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Project.WatchlistApplication.models.Movie;

@Repository
public interface WatchlistRepo extends JpaRepository<Movie, Integer> {

}
