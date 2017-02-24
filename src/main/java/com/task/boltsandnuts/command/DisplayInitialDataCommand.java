package com.task.boltsandnuts.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.task.boltsandnuts.entity.InitialData;
import com.task.boltsandnuts.service.InitialDataService;

public class DisplayInitialDataCommand implements Command {
	private static final Logger LOGGER = LogManager
			.getLogger(DisplayInitialDataCommand.class.getName());

	InitialDataService initialDataService = new InitialDataService();

	public void execute() {

		InitialData initialData = new InitialData();
		initialData = initialDataService.load();

		LOGGER.info("The initial data are:");
		LOGGER.info(String.format("%d %d %d",
				initialData.getBoltBeginQuantity(),
				initialData.getBoltDamagePercent(),
				initialData.getBoltPcPrice()));
		LOGGER.info(String.format("%d %d %d",
				initialData.getNutBeginQuantity(),
				initialData.getNutDamagePercent(), initialData.getNutPcPrice()));

	}
}
