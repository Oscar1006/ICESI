package model;

import java.util.ArrayList;
import java.util.List;

import exception.NegativeNumberException;

public class Recipe {

	private ArrayList<Ingredient> ingredients;

	public Recipe() {
		ingredients = new ArrayList<Ingredient>();
	}

	public String addIngredient(String n, double w) throws NegativeNumberException {
		String message = "Ingredient added";
		Ingredient searched = null;

		if (w >= 0) {

			searched = searchIngredient(n);

			if (searched != null) {
				try {
					searched.addWeight(w);
				} catch (NegativeNumberException e) {
					e.printStackTrace();
				}
			} else {
				Ingredient newIngredient = new Ingredient(n, w);
				ingredients.add(newIngredient);
			}

		} else {
			throw new NegativeNumberException(w);
		}

		return message;
	}

	public String removeIngredient(String n) {
		String message = "Ingredient removed";
		Ingredient searched = null;

		searched = searchIngredient(n);

		if (searched != null) {
			getIngredients().remove(searched);
		} else {
			message = "Ingredient did not exist";
		}

		return message;
	}

	public Ingredient searchIngredient(String name) {
		Ingredient searched = null;

		for (int i = 0; i < ingredients.size() && searched == null; i++) {
			Ingredient current = ingredients.get(i);
			if (current.getName().equals(name)) {
				searched = current;
			}
		}

		return searched;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
}
