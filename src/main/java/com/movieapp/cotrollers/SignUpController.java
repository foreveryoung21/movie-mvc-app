package com.movieapp.cotrollers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.movieapp.models.Role;
import com.movieapp.models.User;
import com.movieapp.services.SignUpService;

@Controller
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService;
	
	@PostMapping("/process_register")
	public String register(User user , Model model) {
		Role  role = new Role();
		Set<Role> set = new HashSet<>();
		
		if(user.getChecked()== false) {
			role.setName("User");
			set.add(role);
			System.out.println("checkbox is false");
			
		}else {
			role.setName("Admin");
			set.add(role);
			System.out.println("checkbox is true");
		}
		
		
	
		
		
		
	
	

		
		
		String password = user.getPassword();
		String encodedPassword = encode(password);
		

		user.setEnabled(true);
		user.setPassword(encodedPassword);
		user.setRoles(set);
		
		
		model.addAttribute("user",user);
		
		signUpService.saveUser(user);
		return "success";
		
		
	}
	
	public String encode( String password) {
		
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		
		return encoder.encode(password);
		
	}

}
