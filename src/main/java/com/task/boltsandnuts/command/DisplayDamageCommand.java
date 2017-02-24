package com.task.boltsandnuts.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.task.boltsandnuts.entity.DamageData;
import com.task.boltsandnuts.service.DamageDataService;

public class DisplayDamageCommand implements Command {
	private static final Logger LOGGER = LogManager
			.getLogger(DisplayDamageCommand.class.getName());
	DamageDataService damageDataService = new DamageDataService();

	public void execute() {

		DamageData damageData = damageDataService.get();

		LOGGER.info("The damage is: " + damageData.getDamage());
	}
}
