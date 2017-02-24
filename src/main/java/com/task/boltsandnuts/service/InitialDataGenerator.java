package com.task.boltsandnuts.service;

import java.util.Random;

import com.task.boltsandnuts.entity.InitialData;

public class InitialDataGenerator {
	public InitialData generateInitialData() {

		InitialData inputData = new InitialData();
		inputData.setBoltBeginQuantity(randomK());
		inputData.setBoltDamagePercent(randomL());
		inputData.setBoltPcPrice(randomM());
		inputData.setNutBeginQuantity(randomK());
		inputData.setNutDamagePercent(randomL());
		inputData.setNutPcPrice(randomM());
		return inputData;
	}

	private int randomK() {
		Random random = new Random();
		int value = random.nextInt(30001 - 100) + 100;
		return value % 100 == 0 ? value : randomK();
	}

	private int randomL() {
		Random random = new Random();
		return random.nextInt(101);
	}

	private int randomM() {
		Random random = new Random();
		return random.nextInt(101 - 1) + 1;
	}
}
