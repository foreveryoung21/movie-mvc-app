package com.movieapp.cotrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.models.Movie;
import com.movieapp.services.MovieService;



@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	
	@RequestMapping(value="/home")
	public String homePage() {
		
		return "home";
		
	}
	
	
	@GetMapping(value="/movieCompare")
	public String movieCompare() {
		
		return "movie_compare";
		
	}
	
	@GetMapping("/allmovies")
	public String getAllMovies(Model model) {
		model.addAttribute("listMovies",movieService.getAllMovies());
		return "movieList";
		
		
	}
	
	@PostMapping("/updatemovie/{id}")
	public String update(@ModelAttribute ("movie") Movie movie,@PathVariable(value="id")  long id) {
		
		System.out.println("this is the id: "+id);
		
		
		movieService.saveMovieId(movie,id);
		
		return "movie_success";
		
	}
	

	
	@GetMapping("/movie/{id}")
	public String updateMovie(@PathVariable(value="id")  long id, Model model) {
		

		Movie movie= movieService.getMovieId(id);
		System.out.println(movie);
		
	
		model.addAttribute("movie",movie);
		return "movie_update";
		
	}
	
	@GetMapping("/deletemovie/{id}")
	public String deleteMovie(@PathVariable(value="id") long id , Model model) {
		Movie movie  =movieService.getMovieId(id);
		model.addAttribute("movie",movie);
		this.movieService.deleteMovieId(id);
		return "deleted_movie";
		
		
	}
}
