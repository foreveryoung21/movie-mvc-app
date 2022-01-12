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

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="history")
@Table(name="history")
public class History {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "history_id")
	private long id;
	@Column(name = "name")
	@JsonProperty(value = "name")
	private String name;
	@Column(name = "path")
	@JsonProperty(value = "path")
	private String path;
	@Column(name = "website")
	@JsonProperty(value = "website")
	private String website;
	@Column(name = "language")
	@JsonProperty(value = "language")
	private String language;
	
	

	
	 @ManyToMany(mappedBy = "histories")
	private Set<User> user= new HashSet<>(); 
	
	public History() {
		super();
	}
	
	

	public History(long id, String name, String path, String website, String language) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.website = website;
		this.language = language;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	@Override
	public String toString() {
		return "History [id=" + id + ", name=" + name + ", path=" + path + ", website=" + website + ", language="
				+ language + "]";
	}



	public Set<User> getUser() {
		return user;
	}



	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	

	
	
	
	
	
	
	

}
