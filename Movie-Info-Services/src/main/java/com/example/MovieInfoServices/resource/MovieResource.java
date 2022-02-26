package com.example.MovieInfoServices.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieInfoServices.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	//List of movie info
	List<Movie> movies = Arrays.asList(
			new Movie("1","Transformers","Action/Sci-fi"),
			new Movie("2", "Titanic", "Romance/Drama"),
			new Movie("3", "The Godfather", "Crime/Drama")
			);
	
	@RequestMapping("/{movieId}")
	public Movie getInfo(@PathVariable("movieId") String movieId) {
		Movie movie = movies.stream().filter(
				temp-> movieId.equals(temp.getMovieId())
				).findAny().orElse(null);
		
		return movie;
	}

}

