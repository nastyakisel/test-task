package com.task.boltsandnuts.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.task.boltsandnuts.entity.InitialData;

public class InitialDataDAO {

	private static final String INPUT_FILE = "input.txt";

	public void save(InitialData inputData) {
		String[] inputArray = new String[2];
		inputArray[0] = String.format("%d %d %d",
				inputData.getBoltBeginQuantity(),
				inputData.getBoltDamagePercent(), inputData.getBoltPcPrice());

		inputArray[1] = String.format("%d %d %d",
				inputData.getNutBeginQuantity(),
				inputData.getNutDamagePercent(), inputData.getNutPcPrice());

		File inputFile = new File(INPUT_FILE);
		try {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(
					inputFile))) {
				for (String line : inputArray) {
					writer.write(line);
					writer.newLine();
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(
					"Error occurred while saving the InitialData", e);
		}
	}

	public InitialData load() {

		List<String> arrayInputs = new ArrayList<>();

		try {
			File inputFle = new File(INPUT_FILE);
			try (BufferedReader reader = new BufferedReader(new FileReader(
					inputFle))) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					arrayInputs.add(line);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(
					"Error occurred while loading the InitialData", e);
		}

		int[][] arrayInp = convertInputsToArray(arrayInputs);

		InitialData inputData = new InitialData();
		inputData.setBoltBeginQuantity(arrayInp[0][0]);
		inputData.setBoltDamagePercent(arrayInp[0][1]);
		inputData.setBoltPcPrice(arrayInp[0][2]);
		inputData.setNutBeginQuantity(arrayInp[1][0]);
		inputData.setNutDamagePercent(arrayInp[1][1]);
		inputData.setNutPcPrice(arrayInp[1][2]);
		return inputData;
	}

	private int[][] convertInputsToArray(List<String> linesToRead) {
		if (linesToRead.size() < 2) {
			throw new RuntimeException(
					"Error occurred because of lack of lines");
		}
		int[][] arrayInputs = new int[2][3];
		for (int i = 0; i < 2; i++) {
			String line = linesToRead.get(i).trim();
			if (line.isEmpty()) {
				throw new RuntimeException(
						"Error occurred because of empty line");
			}
			String[] result = line.split(" ");
			for (int j = 0; j < 3; j++) {
				arrayInputs[i][j] = Integer.parseInt(result[j]);
			}
		}
		return arrayInputs;
	}
}
