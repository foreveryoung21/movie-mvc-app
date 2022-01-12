package com.movieapp.service.test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.models.User;
import com.movieapp.services.MovieService;
import com.movieapp.services.SignUpService;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class SignUpServiceUnitTest {
	
	@Mock
	SignUpService signUpService;
	
	@Test
	public void saveUserTest() {
		User user = new User();
		SignUpService signUpService = Mockito.mock(SignUpService.class);
		signUpService.saveUser(user);
		verify(signUpService,times(1)).saveUser(user);
		
		
		
	}

}
