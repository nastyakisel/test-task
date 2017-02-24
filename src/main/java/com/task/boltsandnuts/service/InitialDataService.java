package com.task.boltsandnuts.service;

import com.task.boltsandnuts.dao.InitialDataDAO;
import com.task.boltsandnuts.entity.InitialData;

public class InitialDataService {
	InitialDataDAO initialDataDAO = new InitialDataDAO();

	public void store(InitialData inputData) {
		initialDataDAO.save(inputData);
	}

	public InitialData load() {
		return initialDataDAO.load();
	}
}
