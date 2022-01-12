package com.movieapp.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.models.Cinema;
import com.movieapp.models.Movie;
import com.movieapp.services.CinemaService;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class CinemaServiceUnitTest {
	
	@Mock
	CinemaService cinemaService;
	
	@Test
	public void saveMovieTest() {
		Cinema cinema = new Cinema(1L,"road","road","road", "road");
		CinemaService cinemaService = Mockito.mock(CinemaService.class);
		cinemaService.saveCinema(cinema);
		verify(cinemaService,times(1)).saveCinema(cinema);
	}

	
	@Test
	public void getAllCinemaTest() {
		List<Cinema> list=new ArrayList<Cinema>();  
		CinemaService cinemaService = Mockito.mock(CinemaService.class);
		when(cinemaService.getAllCinema()).thenReturn(list);
		assertEquals(list,cinemaService.getAllCinema());
		
		
	}
	
	@Test
	public void getCinemaId() {
		Cinema cinema = new Cinema(1L,"road","road","road", "road");
		CinemaService cinemaService = Mockito.mock(CinemaService.class);
		when(cinemaService.getCinemaId(1L)).thenReturn(cinema);
		assertEquals(cinema,cinemaService.getCinemaId(1L));
		
	}
	
	
}
