package com.movieapp.repository.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.models.Cinema;
import com.movieapp.models.History;
import com.movieapp.repository.HistoryRepository;

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
public class HistoryRepositoryUnitTest {
	
	@Mock 
	HistoryRepository historyRepository;

	@Test
	public void saveHistoryTest() {
		History history = new History(10L,"iron man","path","en","youtube");
		
		when(historyRepository.saveAndFlush(any(History.class))).thenReturn(history);
		assertEquals(history,historyRepository.saveAndFlush(history));
		
	}
	
	@Test
	public void deleteHistoryId() {
		historyRepository.deleteById(8L);
		  verify(historyRepository, times(1)).deleteById(eq(8L));
		
	}
	
	
}
