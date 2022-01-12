package com.movieapp.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieapp.models.History;
import com.movieapp.services.HistoryService;

@Controller
public class TrailerController {
	
	@Autowired
	private HistoryService historyService;
	
	@RequestMapping(value="/trailer")
	public String trailer() {
		return "trailer";
		
	}
	

	@GetMapping(value="/historyList")
	public String historyList(Model model) {
		model.addAttribute("history", historyService.getAllHistory());
		
		return "watchHistory";
		
	}
	
	
	@GetMapping("/deletehistory/{id}")
	public String deleteMovie(@PathVariable(value="id") long id , Model model) {
		History history = historyService.getHistoryId(id);
		model.addAttribute("history", history);
	
		this.historyService.deleteHistoryId(id);
		return "deleted_history";
		
		
	}
	
	
	
	
	

}
