package com.movieapp.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.models.History;
import com.movieapp.models.Movie;
import com.movieapp.services.HistoryService;
import com.movieapp.services.MovieService;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class HistoryServiceUnitTest {
	
	@Mock
	HistoryService historyService;
	
	@Test
	public void getAllHistoryTest() {
		List<History> list=new ArrayList<History>();
		HistoryService historyService = Mockito.mock(HistoryService.class);
		when(historyService.getAllHistory()).thenReturn(list);
		assertEquals(list,historyService.getAllHistory());
		
	}
	
	@Test
	public void getHistoryId() {
		History history = new History(10L,"history","history","history","history");
		HistoryService historyService = Mockito.mock(HistoryService.class);
		when(historyService.getHistoryId(10L)).thenReturn(history);
		assertEquals(history,historyService.getHistoryId(10L));
		
		
		
	}
	
	
	

}
