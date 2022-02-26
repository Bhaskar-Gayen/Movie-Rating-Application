package com.example.MovieCatalogServices.models;

public class CatalogItem {
	private String name;
	private String desc;
	private String rateing;
	
	
	public CatalogItem(String name, String desc, String rateing) {
		this.name = name;
		this.desc = desc;
		this.rateing = rateing;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getRateing() {
		return rateing;
	}
	public void setRateing(String rateing) {
		this.rateing = rateing;
	}
	

}
