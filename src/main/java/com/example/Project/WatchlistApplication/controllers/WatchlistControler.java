package com.example.Project.WatchlistApplication.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.Project.WatchlistApplication.models.Movie;
import com.example.Project.WatchlistApplication.services.WatchlistService;

import jakarta.validation.Valid;

@RestController
public class WatchlistControler {

	@Autowired
	private WatchlistService watchlistService;
	
	@GetMapping("watchlist")
	public ModelAndView showMyWatchlist(@RequestParam(required = false) Integer id)
	{
		if(id!= null)
		{
			watchlistService.deleteById(id);
		}
		String viewName = "/watchlist";
		
		Map<String, Object> model = new HashMap<>();
		
		List<Movie> movieList = watchlistService.getMovieList();
		model.put("movieList", movieList);
		model.put("movieCount", movieList.size());
		
		return new ModelAndView(viewName, model);
	}
	
	
	@GetMapping("/movieSubmitForm")
	public ModelAndView getSubmitForm(@RequestParam(required = false) Integer id)
	{
		String viewName = "movieSubmitForm";
		Map<String, Object> model = new HashMap<>();
		if(id==null) {
			model.put("movie",new Movie());
			model.put("currentAction", "Submit");

		}
		else {
			Movie movie = watchlistService.fetchMovieById(id);
			model.put("movie", movie);
			model.put("currentAction", "Update");
		}
		return new ModelAndView(viewName, model);
		
	}
	
	@PostMapping(path = "movieSubmitForm")
	public ModelAndView submitTheMovie(@Valid Movie movie,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return new ModelAndView("movieSubmitForm");
		}
		
		watchlistService.addMovie(movie);
		
		RedirectView rd = new RedirectView();
		rd.setUrl("watchlist");
		
		return new ModelAndView(rd);
	}
	
	@GetMapping("/deleteMovie")
	public ModelAndView getDeleteMoviePage(@RequestParam(name = "id") int id)
	{
		String viewName = "deleteMovie";
		
		Map<String, Object> model = new HashMap<>();
		Movie movie = watchlistService.fetchMovieById(id);
		model.put("movie", movie);
		
		return new ModelAndView(viewName, model);
		
	}
}
