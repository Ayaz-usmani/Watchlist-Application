package com.example.Project.WatchlistApplication.models;

import com.example.Project.WatchlistApplication.models.validations.Priority;
import com.example.Project.WatchlistApplication.models.validations.Rating;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty(message = "Sorry it cannot be empty")
	private String movieName;
	
	@Rating
	private float rating;
	
	private float officialRating;
	
	@Priority
	private String priority;
	
	@Size(max = 50, message = "Comment cannot be more than 50 chars")
	private String comment;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public float getOfficialRating() {
		return officialRating;
	}
	public void setOfficialRating(float officialRating) {
		this.officialRating = officialRating;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
