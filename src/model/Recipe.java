package model;

import java.util.ArrayList;
import java.util.List;

import exception.NegativeNumberException;

// FALTAN LOS BUCLES
public class Recipe {
	private List<Ingredient> ingredients;
	public Recipe() {
		ingredients = new ArrayList<Ingredient>();
	}
	
	public String addIngredient(String n, double w) {
		String message = "Ingredient added";
		Ingredient searched = null;
		for (int i = 0; i < ingredients.size() && searched==null; i++) {
			Ingredient current = ingredients.get(i);
			if(current.getName().equals(n)) {
				searched = current;
			}
		}
		
		if(searched!=null) {
			try {
				searched.addWeight(w);
			} catch (NegativeNumberException e) {
				e.printStackTrace();
			}
		}else {
			Ingredient newIngredient = new Ingredient(n, w);
			ingredients.add(newIngredient);
		}
		return message;
	}
	
	public List<Ingredient> getIngredients(){
		return ingredients;
	}
}
