package com.movieapp.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieapp.models.User;
import com.movieapp.repository.SignUpRepository;
import com.movieapp.services.SignUpService;

@Transactional
@Service
public class SignUpImpl implements SignUpService {
	
	@Autowired
	private SignUpRepository signUpRepository;

	@Override
	public void saveUser(User user) {
		this.signUpRepository.saveAndFlush(user);
	
		
	}
	

}
