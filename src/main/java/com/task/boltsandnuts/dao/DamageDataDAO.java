package com.task.boltsandnuts.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.task.boltsandnuts.entity.DamageData;

public class DamageDataDAO {

	private static final String OUTPUT_FILE = "output.txt";

	public void save(DamageData damageData) {

		String data = String.valueOf(damageData.getDamage());
		File outputFile = new File(OUTPUT_FILE);
		try {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(
					outputFile))) {
				writer.write(data + "\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(
					"Error occurred while saving the DamageData", e);
		}
	}

	public DamageData load() {
		DamageData damageData = new DamageData();
		try {
			File inputFle = new File(OUTPUT_FILE);
			try (BufferedReader reader = new BufferedReader(new FileReader(
					inputFle))) {
				String line = null;
				if ((line = reader.readLine()) != null) {
					damageData.setDamage(Integer.parseInt(line));
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(
					"Error occurred while loading the DamageData", e);
		}
		return damageData;
	}
}
