package com.task.boltsandnuts.service;

import com.task.boltsandnuts.entity.DamageData;
import com.task.boltsandnuts.entity.InitialData;

public class DamageCalculator {
	public DamageData calculate(InitialData initialData) {
		int boltBeginQuantity = initialData.getBoltBeginQuantity();
		float boltDamagePercent = (float) initialData.getBoltDamagePercent() / 100;
		int boltPcPrice = initialData.getBoltPcPrice();
		int nutBeginQuantity = initialData.getNutBeginQuantity();
		float nutDamagePercent = (float) initialData.getNutDamagePercent() / 100;
		int nutPcPrice = initialData.getNutPcPrice();

		int boltRest = (int) (boltBeginQuantity - boltBeginQuantity
				* boltDamagePercent);
		int nutRest = (int) (nutBeginQuantity - nutBeginQuantity
				* nutDamagePercent);

		Integer min = Integer.min(boltRest, nutRest);

		int boltLost = boltBeginQuantity - min;
		int nutLost = nutBeginQuantity - min;

		int damage = boltLost * boltPcPrice + nutLost * nutPcPrice;

		DamageData outputData = new DamageData();
		outputData.setDamage(damage);
		return outputData;
	}
}
