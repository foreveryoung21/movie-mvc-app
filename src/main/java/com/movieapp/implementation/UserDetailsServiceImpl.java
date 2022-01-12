package com.movieapp.implementation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieapp.MyUserDetails;
import com.movieapp.models.History;
import com.movieapp.models.Movie;
import com.movieapp.models.User;
import com.movieapp.repository.UserRepository;
import com.movieapp.services.UserService;


@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService,UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new MyUserDetails(user);
	}

	@Override
	public void saveUserMovie(Movie movie) {
		
		Movie film = movie;
		System.out.println("this is the movie: "+film.getTitle());
		
		 Set<Movie> movies= new HashSet<>(); 

		 movies.add(film);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = ((MyUserDetails) principal).getUser();
    	
    	user.setMovies(movies);
    	
    	userRepository.save(user);
   
    	
		
	}

	@Override
	public void saveUserHistory(History history) {
		 Set<History> histories= new HashSet<>(); 

		 histories.add(history);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = ((MyUserDetails) principal).getUser();
    	
    	user.setHistories(histories);
    	
    	userRepository.save(user);
   
    	
		
	}

	
}
