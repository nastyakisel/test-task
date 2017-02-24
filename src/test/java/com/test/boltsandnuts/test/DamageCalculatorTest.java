package com.test.boltsandnuts.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.task.boltsandnuts.entity.DamageData;
import com.task.boltsandnuts.entity.InitialData;
import com.task.boltsandnuts.service.DamageCalculator;

public class DamageCalculatorTest {

	@Test
	public void calculateWhenBoltsDamageMore() throws Exception {
		DamageCalculator damageCalculator = new DamageCalculator();
		InitialData initialData = new InitialData();
		initialData.setBoltBeginQuantity(1000);
		initialData.setBoltDamagePercent(80);
		initialData.setBoltPcPrice(50);
		initialData.setNutBeginQuantity(1200);
		initialData.setNutDamagePercent(20);
		initialData.setNutPcPrice(30);
		DamageData receivedResult = damageCalculator.calculate(initialData);
		DamageData expectedResult = new DamageData();
		expectedResult.setDamage(70000);
		assertEquals(receivedResult.getDamage(), expectedResult.getDamage());
	}

	@Test
	public void calculateWhenNutsDamageMore() throws Exception {
		DamageCalculator damageCalculator = new DamageCalculator();
		InitialData initialData = new InitialData();
		initialData.setBoltBeginQuantity(1500);
		initialData.setBoltDamagePercent(13);
		initialData.setBoltPcPrice(54);
		initialData.setNutBeginQuantity(1200);
		initialData.setNutDamagePercent(90);
		initialData.setNutPcPrice(35);
		DamageData receivedResult = damageCalculator.calculate(initialData);
		DamageData expectedResult = new DamageData();
		expectedResult.setDamage(112320);
		assertEquals(receivedResult.getDamage(), expectedResult.getDamage());
	}

	@Test
	public void WhenBoltsAndNutsDamageEquals() throws Exception {
		DamageCalculator damageCalculator = new DamageCalculator();
		InitialData initialData = new InitialData();
		initialData.setBoltBeginQuantity(2000);
		initialData.setBoltDamagePercent(25);
		initialData.setBoltPcPrice(45);
		initialData.setNutBeginQuantity(2500);
		initialData.setNutDamagePercent(40);
		initialData.setNutPcPrice(21);
		DamageData receivedResult = damageCalculator.calculate(initialData);
		DamageData expectedResult = new DamageData();
		expectedResult.setDamage(43500);
		assertEquals(receivedResult.getDamage(), expectedResult.getDamage());
	}
}
