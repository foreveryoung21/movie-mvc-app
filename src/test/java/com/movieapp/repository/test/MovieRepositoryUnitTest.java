
package com.movieapp.repository.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert; 
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.movieapp.models.Movie;
import com.movieapp.repository.MovieRepository;




@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class MovieRepositoryUnitTest {
	
	private Movie movie;
	
	@Mock
	MovieRepository movieRepository;
	
	private MockMvc mockMvc;
	
	@Test
	public void saveMovieTest() {
		

	 movie = new Movie(1L,"car","car","car");

	when(movieRepository.saveAndFlush(any(Movie.class))).thenReturn(movie);
	assertEquals(movie,movieRepository.saveAndFlush(movie));


	}

	@Test
	public void findById() {
		
		
		Movie m= new Movie(1L,"cars","cars","cars");
	
		when(movieRepository.findById(1L)).thenReturn(Optional.of(m));
		assertEquals(Optional.of(m),movieRepository.findById(1L));
		
	
		
	}
	
	
	@Test
	public void deleteById() {
		
		movieRepository.deleteById(1L);
	
		 verify(movieRepository, times(1)).deleteById(eq(10L));
		
	}
	
	
	
	
}
