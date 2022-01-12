package com.movieapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity(name="movie")
@Table(name = "movie")


public class Movie {
	@Id
	@Column(name = "movie_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title")
	@JsonProperty(value = "Title")
	private String title;
	@Column(name = "year")
	@JsonProperty(value = "Year")
	private String year;
	@Column(name = "poster")
	@JsonProperty(value = "Poster")
	private String poster;
	
 
	 @ManyToMany(mappedBy = "movies")
	private Set<User> user= new HashSet<>(); 
	
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Movie() {
		super();
	}

	public Movie(Long id, String title, String year, String poster) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.poster = poster;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return year;
	}
	public void setTitle(String title) {
		year = title;
	}

	public String getYear() {
		return title;
	}
	public void setYear(String year) {
		title = year;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", poster=" + poster + "]";
	}

	


	

	
	
	

	
}
