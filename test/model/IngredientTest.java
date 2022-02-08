package model;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.NegativeNumberException;

public class IngredientTest {
	
	private Ingredient ingredient;
	
	private void setUpStage1() {
		ingredient = new Ingredient("Tomate", 245);
	}
	
	@Test
	public void testAddWeight() {
		setUpStage1();
		try {
			ingredient.addWeight(54);
		} catch (NegativeNumberException e) {
			fail("No deberia lanzar excepcion");
		}
		assertTrue("El peso no  se ha actualizado", 299 == ingredient.getWeight());
		
	}
	
	@Test
	public void testAddWeight2() {
		setUpStage1();
		try {
			ingredient.addWeight(-100);
			fail("Debe fallar");
		} catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
		}
		assertTrue("El peso no  se ha actualizado", 245 == ingredient.getWeight());
	}
	
	@Test
	public void testRemoveWeight() {
		setUpStage1();
		try {
			ingredient.removeWeight(45);
			
		} catch (NegativeNumberException e) {
			fail("No debe lanzar excepcion");
		}
		assertTrue("El peso se ha actualizado", 200 == ingredient.getWeight());
	}
	
	@Test
	public void testRemoveWeight2() {
		setUpStage1();
		try {
			ingredient.removeWeight(-100);
			fail("Debe fallar");
		} catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
		}
		assertTrue("El peso no  se ha actualizado", 245 == ingredient.getWeight());
	}

}
