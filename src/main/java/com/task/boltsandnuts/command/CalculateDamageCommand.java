package com.task.boltsandnuts.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.task.boltsandnuts.entity.DamageData;
import com.task.boltsandnuts.entity.InitialData;
import com.task.boltsandnuts.service.DamageCalculator;
import com.task.boltsandnuts.service.DamageDataService;
import com.task.boltsandnuts.service.InitialDataService;

public class CalculateDamageCommand implements Command {
	private static final Logger LOGGER = LogManager
			.getLogger(CalculateDamageCommand.class.getName());

	InitialDataService initialDataService = new InitialDataService();
	DamageCalculator damageCalculator = new DamageCalculator();
	DamageDataService damageDataService = new DamageDataService();

	public void execute() {

		InitialData initialData = initialDataService.load();
		DamageData damageData = damageCalculator.calculate(initialData);
		damageDataService.store(damageData);

		LOGGER.info("The damage is calculated.");
	}
}
