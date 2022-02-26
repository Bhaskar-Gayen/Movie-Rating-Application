package com.example.MovieCatalogServices.models;

public class Movie {
	private String movieId;
	private String name;
	private String desc;
	
	public Movie() {	}
	
	public Movie(String movieId, String name, String desc) {
		
		this.movieId = movieId;
		this.name = name;
		this.desc= desc;
	}
	
	public String getDesc() {
		return desc;
	}

	public String getMovieId() {
		return movieId;
	}
	public String getName() {
		return name;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	 public void setName(String name) {
		this.name = name;
	}

}
