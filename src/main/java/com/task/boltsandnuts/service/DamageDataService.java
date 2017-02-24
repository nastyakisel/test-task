package com.task.boltsandnuts.service;

import com.task.boltsandnuts.dao.DamageDataDAO;
import com.task.boltsandnuts.entity.DamageData;

public class DamageDataService {
	DamageDataDAO damageDataDAO = new DamageDataDAO();

	public void store(DamageData damageData) {
		damageDataDAO.save(damageData);
	}

	public DamageData get() {
		return damageDataDAO.load();
	}
}
