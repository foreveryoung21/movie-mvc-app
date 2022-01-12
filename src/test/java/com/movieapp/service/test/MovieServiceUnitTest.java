package com.movieapp.service.test;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.models.Movie;
import com.movieapp.services.MovieService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class MovieServiceUnitTest {
	
	@Mock
	MovieService movieService;
	
	
	
	@Test
	@DisplayName("test getAllMovies method")
	public void getAllMoviesTest() throws Exception{
		List<Movie> list=new ArrayList<Movie>();  
		
		Movie movie = new Movie(8L,"","","");
		
		MovieService movieService = Mockito.mock(MovieService.class);
		
		// when the movie service is called then a list is the expected result
		when(movieService.getAllMovies()).thenReturn(list);
	
		assertEquals(movieService.getAllMovies(),movie);
	}
	
	
	@Test
	@DisplayName("test getMovieId method")
	public void getMovieIdTest() {
		
		Movie movie = new Movie(1L,"car","car","car");
		MovieService movieService = Mockito.mock(MovieService.class);
		when(movieService.getMovieId(movie.getId())).thenReturn(movie);
		assertEquals(movie,movieService.getMovieId(movie.getId()));
		
	}
	
	
	
	@Test 
	@DisplayName("test saveMovie method")
	public void saveMovieIdTest() {
		Movie movie = new Movie(1L,"car","car","car");
		MovieService movieService = Mockito.mock(MovieService.class);
		movieService.saveMovie(movie);
		verify(movieService,times(1)).saveMovie(eq(movie));

	}
	
	

}
