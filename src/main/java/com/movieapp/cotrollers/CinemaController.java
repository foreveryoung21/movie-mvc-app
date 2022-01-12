package com.movieapp.cotrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.movieapp.models.Cinema;
import com.movieapp.services.CinemaService;

@Controller
public class CinemaController {
	
	@Autowired
	private CinemaService cinemaService;
	
	@RequestMapping(value="/addcinema")
	public String showCinema(Model model) {
		Cinema cinema = new Cinema();
		
		model.addAttribute("cinema",cinema);
	   return "cinema";
	}
	

	@PostMapping("/addcinema")
	public String addCinema(@ModelAttribute("cinema") Cinema cinema ) {
		System.out.println(cinema);
		cinemaService.saveCinema(cinema);
		
		
		return "cinema_success";
		
	}

	@GetMapping("/allcinema")
	public String getAllCinema( Model model){
		model.addAttribute("listCinema",cinemaService.getAllCinema());
		
		
		return "cinemaList";
		
	}
	
	// use the id from pathvariable to get object from service
	@GetMapping("/cinema/{id}")
	public String updateCinemaForm(@PathVariable(value="id")  long id, Model model) {
		
		// get cinema from the service 
		Cinema cinema = cinemaService.getCinemaId(id);
		System.out.println(cinema);
		
		// set cinema as a model attribute to pre-popule the form
		model.addAttribute("cinema",cinema);
		return "update_cinema";
		
	}
	
	@GetMapping("/deletecinema/{id}")
	public String deleteMovie(@PathVariable(value="id") long id ,Model model) {
		Cinema cinema = cinemaService.getCinemaId(id);
		model.addAttribute("cinema",cinema);
		this.cinemaService.deleteCinemaId(id);
		
		
		return "deleted_cinema";
		
		
	}
	
	

}
