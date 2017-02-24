package com.task.boltsandnuts.exe;

import java.util.Scanner;

import com.task.boltsandnuts.command.Command;
import com.task.boltsandnuts.command.CommandProvider;

public class Executer {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			CommandProvider provider = new CommandProvider();
			while (true) {

				System.out.println("Choose menu item: ");
				System.out.print("1. Display the initial data." + "\n"
						+ "2. Generate new initial data." + "\n"
						+ "3. Calculate the damage." + "\n"
						+ "4. Display the damage." + "\n");

				String menuItem = scanner.nextLine();

				Command command = provider.getCommand(menuItem);
				if (command != null) {
					command.execute();
				} else {
					System.out.println("The input is incorrect. Try again.");
				}
			}
		}
	}
}