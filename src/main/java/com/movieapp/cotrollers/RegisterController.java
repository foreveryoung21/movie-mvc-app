package com.movieapp.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieapp.models.User;

@Controller
public class RegisterController {


	
	@RequestMapping(value="/register")
	public String loginPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
		
	}

	
	
	
}
