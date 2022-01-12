package com.movieapp.cotrollers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.models.Movie;
import com.movieapp.services.UserService;



@RestController
public class PostController {
	
	@Autowired
	private UserService userService;
	
	

	@PostMapping("/film")
	public String saveMovie(@RequestBody Movie film) {
		System.out.println(film.getTitle());
    	 userService.saveUserMovie(film);
		return "hello.html";
		
	}
	
	

}
