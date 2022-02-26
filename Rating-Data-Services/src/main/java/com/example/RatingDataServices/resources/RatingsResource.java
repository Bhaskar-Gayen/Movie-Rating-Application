package com.example.RatingDataServices.resources;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RatingDataServices.models.Rating;
import com.example.RatingDataServices.models.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingsResource {
	
	@RequestMapping("/{movieId}")
	public Rating setRating(@PathVariable("movieId") String movieId) {
		
		return new Rating(movieId, "7");	
	}
	
	@RequestMapping("user/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("1", "7"),
				new Rating("2",  "7.8"),
				new Rating("3",  "9.2")
				);
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

}
