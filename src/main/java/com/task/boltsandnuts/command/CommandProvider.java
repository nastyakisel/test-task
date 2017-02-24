package com.task.boltsandnuts.command;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("1", new DisplayInitialDataCommand());
		commands.put("2", new GenerateNewInitialDataCommand());
		commands.put("3", new CalculateDamageCommand());
		commands.put("4", new DisplayDamageCommand());
	}

	public Command getCommand(String menuName) {
		return commands.get(menuName);
	}
}
