package com.example.MovieCatalogServices.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.example.MovieCatalogServices.models.CatalogItem;
import com.example.MovieCatalogServices.models.Movie;
import com.example.MovieCatalogServices.models.UserRating;

@RestController
@RequestMapping("/catalogs")
public class MovieCatalogResource {
	//Create new Rest Template object inject method
	@Autowired
	private RestTemplate restTemplate;
	
	/*//create WebClient object
	@Autowired
	private WebClient.Builder webClientBuilder; 
	*/

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")String userId){

		//get all rated movies ID
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingdata/user/"+userId,UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			
			// for each movie id call movie info service and get details
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+ rating.getMovieId(), Movie.class);
			
			//put all of them together
			return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
			})
			.collect(Collectors.toList());
		
	}

}

/*
 //fetch the movie data through webClient 
Movie movie = webClientBuilder.build().get()
.uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve()
.bodyToMono(Movie.class)
.block();
*/
