package com.movieapp.controller.test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hamcrest.Matchers;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.movieapp.MovieApplication;
import com.movieapp.cotrollers.MovieController;
import com.movieapp.models.Movie;
import com.movieapp.services.MovieService;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc

public class MovieControllerIntegrationTest {
	
	private MockMvc mockMvc;
	

	// InjectMocks annotation was here
	@MockBean
	private MovieController movieController;
	
	@Mock
	MovieService movieService;
	
	
	

	@Before
	public void setUp() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
 
		mockMvc = MockMvcBuilders.standaloneSetup(movieController).setViewResolvers(viewResolver)
		.build();
		
	}
	
	@Test
	@DisplayName("test getAllMovies method")
	public void testgetAllMovies() throws Exception {
		List<Movie> list=new ArrayList<Movie>(); 
		 this.mockMvc.perform(get("/allmovies").flashAttr("listMovies", list))
         .andExpect(status().isOk());
		

		
		
	}

	@Test
	@DisplayName("testing view")
	
	// Unit testing the method along with the view 
	public void testHomePageView() throws Exception {
		 this.mockMvc.perform(get("/home"))
         .andExpect(status().isOk())
         .andExpect(view().name("home"))
         .andDo(MockMvcResultHandlers.print());
	
     
	}
	
	// Unit testing the method 

	// Unit testing movieCompare method
	@Test
	@DisplayName("testing movieCompare method")
	public void testMovieCompare() throws Exception {
		 this.mockMvc.perform(get("/movieCompar"))
         .andExpect(status().isOk())
         .andDo(MockMvcResultHandlers.print());
	
	}
	


	
	
	
	@Test
	@DisplayName("testing delete method")
	
	// Unit testing the method along with the view 
	public void testDeleteMovvie() throws Exception {
		Movie movie = new Movie(1L,"car","car","car");
		MovieService movieService = Mockito.mock(MovieService.class);
	
		
		when(movieService.getMovieId(8L)).thenReturn(movie);
		 this.mockMvc.perform(get("/deletemovie/{id}",8L).flashAttr("movie", movie))
	
         .andExpect(status().isOk())
         .andDo(MockMvcResultHandlers.print());
	

	
		
        
	
     
	}
	
	@Test
	public void testUpdateMovie() throws Exception {
		
		MovieService movieService = Mockito.mock(MovieService.class);
		 Movie movie = new Movie(1L,"car","car","car");
	     doNothing().when(movieService).saveMovie(any());

		 this.mockMvc.perform(post("/updatemovie/{id}",8L))
         .andExpect(status().isOk())
         .andDo(MockMvcResultHandlers.print());

		
		 
	
		
	}
	

	
	
	}
	
	
	


