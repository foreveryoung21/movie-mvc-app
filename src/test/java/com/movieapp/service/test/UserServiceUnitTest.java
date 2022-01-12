package com.movieapp.service.test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.models.History;
import com.movieapp.models.Movie;
import com.movieapp.models.User;
import com.movieapp.services.MovieService;
import com.movieapp.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class UserServiceUnitTest {
	
	@Mock
	UserService userService;
	
	@Test
	public void saveUserMovieTest() {
		Movie movie = new Movie();
		UserService userService = Mockito.mock(UserService.class);
		userService.saveUserMovie(movie);
		verify(userService,times(1)).saveUserMovie(eq(movie));
		
		
		
		
		
	}
	
	
	@Test
	public void saveUserHistoryTest() {
		History history = new History();
		UserService userService = Mockito.mock(UserService.class);
		userService.saveUserHistory(history);
		verify(userService,times(1)).saveUserHistory(history);
		
		
		
		
		
	}
	
}
