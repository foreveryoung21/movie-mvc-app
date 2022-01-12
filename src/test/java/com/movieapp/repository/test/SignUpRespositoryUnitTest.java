package com.movieapp.repository.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.models.History;
import com.movieapp.models.User;
import com.movieapp.repository.SignUpRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class SignUpRespositoryUnitTest {
	
	@Mock
	SignUpRepository signUpRepository;
	
	@Test
	public void saveUserTest() {
		User user = new User();
		
		when(signUpRepository.saveAndFlush(any(User.class))).thenReturn(user);
		assertEquals(user,signUpRepository.saveAndFlush(user));
		
	}
	

}
