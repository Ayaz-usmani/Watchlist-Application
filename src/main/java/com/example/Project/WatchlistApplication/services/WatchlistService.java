package com.example.Project.WatchlistApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.example.Project.WatchlistApplication.models.Movie;
import com.example.Project.WatchlistApplication.repositories.WatchlistRepo;

@Service
public class WatchlistService {
	
	@Autowired
	private WatchlistRepo watchlistRepo;
	
	@Autowired
	private OfficialRatingService officialRatingService;
	
	public List<Movie> getMovieList()
	{
//		return watchlistRepo.findAll();
			List<Movie> movies = sortMovies();
	        return movies;
	}

	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		String movieName = movie.getMovieName();
		Float officialRating = officialRatingService.getOfficialRating(movieName);
		if(officialRating!=null)
			movie.setOfficialRating(officialRating);
		else 
			officialRating = 0.0f;
		watchlistRepo.save(movie);
	}

	public Movie fetchMovieById(Integer id) {
		// TODO Auto-generated method stub
		return watchlistRepo.findById(id).get();
	}

	public void delete(Movie movie) {
		// TODO Auto-generated method stub
		watchlistRepo.delete(movie);
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		watchlistRepo.deleteById(id);
	}
	
	private List<Movie> sortMovies()
	{
		String sortBy ="rating";
		String sortDir = "ASC";
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.DESC.name())? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();

	    List<Movie> movies = watchlistRepo.findAll(sort);
	    
	    return movies;
	}
	
}
