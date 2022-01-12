package com.movieapp.models;

public class CinemaType {
	
	private String name;
	
	public CinemaType() {
	
	}
	

	public CinemaType(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CinemaType [name=" + name + "]";
	}
	
	
	
	

}
