package com.example.Project.WatchlistApplication.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class OfficialRatingService {
	
	String myApiURL = "https://www.omdbapi.com/?i=tt3896198&apikey=dd13da05&t=";
	
	public Float getOfficialRating(String movieName)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<ObjectNode> response = restTemplate.getForEntity(myApiURL+movieName, ObjectNode.class);
			ObjectNode movieData = response.getBody();
			String rating = movieData.findPath("imdbRating").asText();
			return Float.parseFloat(rating);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
}
