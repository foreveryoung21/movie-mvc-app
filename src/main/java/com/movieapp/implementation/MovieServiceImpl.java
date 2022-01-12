package com.movieapp.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.Query;
import javax.websocket.Session;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PreRemove;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieapp.MyUserDetails;
import com.movieapp.models.Movie;
import com.movieapp.models.User;
import com.movieapp.repository.MovieRepository;
import com.movieapp.services.MovieService;




@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@PersistenceContext
    EntityManager em;





	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = ((MyUserDetails) principal).getUser();
   
    	
    	Long id = user.getId();
    	Query query =   em.createNativeQuery("SELECT *\n"
    			+ "FROM movie\n"
    			+ "JOIN movie_user ON movie_user.movie_id = movie.movie_id\n"
    			+ "JOIN users ON movie_user.user_id = users.user_id\n"
    			+ "WHERE users.user_id = ?1",Movie.class);
    	
    	query.setParameter(1, id);
    	
    	 @SuppressWarnings("unchecked")
		List<Movie> list = (List<Movie>) query.getResultList();
    
    	
    	 System.out.println(list.toString());
		
		return list;
	}



	@Override
	public Movie getMovieId(long id) {
		Optional<Movie>optional = movieRepository.findById(id);
		Movie movie=null;
		if(optional.isPresent()) {
			movie = optional.get();
		}else {
			throw new RuntimeException("Employee not found for id::" +id);
		}
		return movie;
	}



	

   
	public void deleteMovieId(long id) {
	
	
	

		
	    // Other business logic

	    movieRepository.deleteById(id);
	    

		
		
	}



	@Override
	public void saveMovie(Movie movie) {
		 Set<User> users= new HashSet<>(); 
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = ((MyUserDetails) principal).getUser();
    	users.add(user);
    	
    	movie.setUser(users);
    	movieRepository.saveAndFlush(movie);
    	
		// TODO Auto-generated method stub

	

  
    	
	// performing three sepereate native queries to database 
    	this.movieRepository.saveAndFlush(movie);
	}



	@Override
	public void saveMovieId(Movie film,long id) {
		//Optional<Movie> movie = this.movieRepository.findById(id);
	
		this.movieRepository.saveAndFlush(film);
		
	}



	
	
	
	

}
