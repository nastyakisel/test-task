package com.task.boltsandnuts.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.task.boltsandnuts.entity.InitialData;
import com.task.boltsandnuts.service.InitialDataGenerator;
import com.task.boltsandnuts.service.InitialDataService;

public class GenerateNewInitialDataCommand implements Command {
	private static final Logger LOGGER = LogManager
			.getLogger(GenerateNewInitialDataCommand.class.getName());
	InitialDataGenerator initialDataGenerator = new InitialDataGenerator();
	InitialDataService initialDataService = new InitialDataService();

	public void execute() {
		InitialData initialData = initialDataGenerator.generateInitialData();
		initialDataService.store(initialData);
		LOGGER.info("The new data are generated.");
	}
}
