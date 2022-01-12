package com.movieapp.repository.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.movieapp.models.Cinema;
import com.movieapp.models.Movie;
import com.movieapp.repository.CinemaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class CinemaRepositoryUnitTest {
	
	@Mock
	CinemaRepository cinemaRepository;
	
	private MockMvc mockMvc;
	
	
	@Test
	public void  saveCinemaTest() {
		
		Cinema cinema = new Cinema(8L,"road","road","road","road");
		
		when(cinemaRepository.saveAndFlush(any(Cinema.class))).thenReturn(cinema);
		assertEquals(cinema,cinemaRepository.saveAndFlush(cinema));
		
	}
	
	@Test
	public void getAllCinemaTest() {
		 List<Cinema> list = new ArrayList<>();
		 list.add(new Cinema(8L,"road","road","road","road"));
		 list.add(new Cinema(10L,"street","streert","street","street"));
		 
		 
		 when(cinemaRepository.findAll()).thenReturn(list);
		 assertEquals(list,cinemaRepository.findAll());
		 
	}
	
	@Test
	public void getCinemaIdTest() {
		Long id =8L;
		
		Cinema cinema = new Cinema(8L,"road","road","road","road");
		
		when(cinemaRepository.findById(id)).thenReturn(Optional.of(cinema));
		assertEquals(Optional.of(cinema),cinemaRepository.findById(id));
		
		
		
	}
	
	@Test
	public void deleteCinemaIdTest() {
		
		cinemaRepository.deleteById(8L);
	    verify(cinemaRepository, times(1)).deleteById(eq(8L));
		
		
	}
	
	
	
	
	
	

}
