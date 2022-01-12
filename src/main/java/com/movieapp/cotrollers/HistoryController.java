package com.movieapp.cotrollers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.models.History;
import com.movieapp.services.UserService;

@RestController
public class HistoryController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/trailer")
	public String saveTrailer(@RequestBody History film) {
      
		userService.saveUserHistory(film);
		return "hello.html";
		
	}
	

}
