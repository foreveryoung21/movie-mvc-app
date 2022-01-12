package com.movieapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="cinema")
@Table(name="cinema")
public class Cinema {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    
    @Column(name = "cinemaName")
	@JsonProperty(value = "cinemaName")
	private String cinemaName;
    @Column(name = "city")
   	@JsonProperty(value = "city")
	private String city;
    @Column(name = "cinemaType")
   	@JsonProperty(value = "cinemaType")
	private String cinemaType;
    
    @Column(name = "address")
   	@JsonProperty(value = "address")
	private String address;

    
    
    
    
    
    
    
    
    
    
    
	public Cinema() {
		super();
	}

	public Cinema(long id, String cinemaName, String city, String cinemaType, String address) {
		super();
		this.id = id;
		this.cinemaName = cinemaName;
		this.city = city;
		this.cinemaType = cinemaType;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCinemaType() {
		return cinemaType;
	}

	public void setCinemaType(String cinemaType) {
		this.cinemaType = cinemaType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", cinemaName=" + cinemaName + ", city=" + city + ", cinemaType=" + cinemaType
				+ ", address=" + address + "]";
	}

	
	
	
	
	
	
	
	
	

}
