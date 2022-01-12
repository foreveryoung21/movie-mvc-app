package com.movieapp.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieapp.MyUserDetails;
import com.movieapp.models.History;
import com.movieapp.models.User;
import com.movieapp.repository.HistoryRepository;

@Transactional
@Service
public class HistoryServiceImpl implements HistoryService {
	
	@Autowired
	private HistoryRepository historyRepository;
	
	@PersistenceContext
    EntityManager em;


	@Override
	public void saveHistory(History history) {
		this.historyRepository.saveAndFlush(history);
		
	}

	@Override
	public List<History> getAllHistory() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = ((MyUserDetails) principal).getUser();
    	
    	Long id = user.getId();
    	Query query =   em.createNativeQuery("SELECT *\n"
    			+ "FROM history\n"
    			+ "JOIN history_user ON history_user.history_id = history.history_id\n"
    			+ "JOIN users ON history_user.user_id = users.user_id\n"
    			+ "WHERE users.user_id = ?1",History.class);
    	
    	query.setParameter(1, id);
		
    	 @SuppressWarnings("unchecked")
 		List<History> list = (List<History>) query.getResultList();
     	 
     	

     
		return list;
	}

	@Override
	public void deleteHistoryId(long id) {
		
		this.historyRepository.deleteById(id);
		
	}

	@Override
	public History getHistoryId(long id) {
		Optional<History>optional = historyRepository.findById(id);
		History history=null;
		if(optional.isPresent()) {
			history= optional.get();
		}else {
			throw new RuntimeException("Employee not found for id::" +id);
		}
		return history;
		//

	}
	
	
}
