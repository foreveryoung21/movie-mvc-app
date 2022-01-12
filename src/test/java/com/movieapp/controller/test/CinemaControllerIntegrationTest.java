package com.movieapp.controller.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.movieapp.cotrollers.CinemaController;
import com.movieapp.models.Cinema;
import com.movieapp.models.Movie;
import com.movieapp.services.CinemaService;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc

public class CinemaControllerIntegrationTest {
	
	private MockMvc mockMvc;
	
	
	@MockBean
	private CinemaController cinemaController;
	
	@Mock
	CinemaService cinemaService;
	
	@Before
	public void setUp() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
 
		mockMvc = MockMvcBuilders.standaloneSetup(cinemaController).setViewResolvers(viewResolver)
		.build();
		
	}
	
	@Test
	public void testShowCinema() throws Exception {
		Cinema cinema = new Cinema();
		 this.mockMvc.perform(get("/addcinema").flashAttr("cinema", cinema))
         .andExpect(status().isOk());
		
	}
	
	
	@Test
	public void addCinemaTest() throws Exception {
		Cinema cinema = new Cinema();
		doNothing().when(cinemaService).saveCinema(cinema);
		
		 this.mockMvc.perform(post("/addcinema"))
         .andExpect(status().isOk())
         .andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	public void getAllCinema() throws Exception {
		List<Cinema> list=new ArrayList<Cinema>(); 
		
		when(cinemaService.getAllCinema()).thenReturn(list);
		 this.mockMvc.perform(get("/addcinema").flashAttr("listCinema",cinemaService.getAllCinema()))
         .andExpect(status().isOk());
		
	}
	
	@Test
	public void updateCinemaForm() throws Exception {
		Cinema cinema = new Cinema();
		
		when(cinemaService.getCinemaId(8L)).thenReturn(cinema);
		 this.mockMvc.perform(get("/cinema/{id}",8L).flashAttr("listCinema",cinemaService.getCinemaId(8L)))
         .andExpect(status().isOk());
	}
	
	@Test
	public void deleteCinemaTest() throws Exception {
		Cinema cinema = new Cinema();
		
		when(cinemaService.getCinemaId(8L)).thenReturn(cinema);
		
		 this.mockMvc.perform(get("/deletecinema/{id}",8L).flashAttr("movie", cinemaService.getCinemaId(8L)))
			
         .andExpect(status().isOk())
         .andDo(MockMvcResultHandlers.print());
		 cinemaService.deleteCinemaId(8L);
		 verify(cinemaService, times(1)).deleteCinemaId(8L);
		
		
	}

	
	
	

}
