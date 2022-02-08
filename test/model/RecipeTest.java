package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import exception.NegativeNumberException;

public class RecipeTest {
	private Recipe recipe;

	public void setUpStage1() {
		recipe = new Recipe();
	}

	public void setUpStage2() {
		recipe = new Recipe();
		recipe.getIngredients().add(new Ingredient("Cebolla", 315));
		recipe.getIngredients().add(new Ingredient("Ajo", 58));
		recipe.getIngredients().add(new Ingredient("Arroz", 520));
	}

	@Test
	public void testAddIngredient() {
		setUpStage1();

		try {
			recipe.addIngredient("Sal", 12);
		} catch (NegativeNumberException e) {
			fail("No debe lanzar excepcion");
		}
		assertEquals("La receta no tiene un ingrediente", 1, recipe.getIngredients().size());
		assertEquals("No coinciden los ingredientes", "Sal", recipe.getIngredients().get(0).getName());
		assertTrue("No coincide el peso", 12 == recipe.getIngredients().get(0).getWeight());

	}

	@Test
	public void testAddIngredient2() {
		setUpStage2();

		try {
			recipe.addIngredient("Pimienta", 6);
		} catch (NegativeNumberException e) {
			fail("No debe lanzar excepcion");
		}
		assertEquals("La receta no tiene 4 ingredientes", 4, recipe.getIngredients().size());
		int lastIngredientIndex = recipe.getIngredients().size() - 1;
		assertEquals("El ultimo ingrediente no coincide", "Pimienta",
				recipe.getIngredients().get(lastIngredientIndex).getName());
		assertTrue("No coincide el peso", 6 == recipe.getIngredients().get(lastIngredientIndex).getWeight());
	}

	@Test
	public void testAddIngredient3() {
		setUpStage2();

		try {
			recipe.addIngredient("Ajo", 21);
		} catch (NegativeNumberException e) {
			fail("No debe lanzar excepcion");
		}
		assertEquals("La receta no tiene 3 ingredientes", 3, recipe.getIngredients().size());
		Ingredient ajo = recipe.searchIngredient("Ajo");
		assertTrue("Ajo no exite", ajo != null);
		assertTrue("No coincide el peso", 79 == ajo.getWeight());

	}

	@Test
	public void testRemoveIngredient() {
		setUpStage2();
		recipe.removeIngredient("Ajo");
		assertEquals("La receta no tiene 2 ingredientes", 2, recipe.getIngredients().size());
		Ingredient ajo = recipe.searchIngredient("Ajo");
		assertTrue("Ajo no se ha removido", ajo == null);
		
		for(int i = 0; i < recipe.getIngredients().size(); i++) {
			System.out.println(recipe.getIngredients().get(i).getName());
		}
	}

}
