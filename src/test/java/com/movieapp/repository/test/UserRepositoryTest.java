package com.movieapp.repository.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.models.Movie;
import com.movieapp.models.User;
import com.movieapp.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class UserRepositoryTest {
	
	@Mock
	UserRepository userRepository;
	
	
	@Test
	public void loadUserByUsernameTest() {
		User user = new User();
		user.setUsername("user");
		
		when(userRepository.getUserByUsername("user")).thenReturn(user);
		assertEquals(user,userRepository.getUserByUsername("user"));
		
	}
	
	@Test
	public void saveUserMovie() {
		
		User user = new User();
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user,userRepository.save(user));
	}
	


}
