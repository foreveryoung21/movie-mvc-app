package com.movieapp.services;

import java.util.List;

import com.movieapp.models.History;

public interface HistoryService {

	void saveHistory(History history);
	List<History> getAllHistory();
	void deleteHistoryId(long id);
	History getHistoryId(long id);
}
