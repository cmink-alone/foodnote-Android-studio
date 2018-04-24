package com.example.trio.foodnote.model;

import java.util.ArrayList;

/**
 * Created by ASUS on 19/03/2018.
 */

public class ShoppingCart {
    private int recipe_index;
    private ArrayList<Integer> ingredients_indexes = new ArrayList<>();

    public int getRecipe_index() {
        return recipe_index;
    }

    public void setRecipe_index(int recipe_index) {
        this.recipe_index = recipe_index;
    }

    public ArrayList<Integer> getIngredients_indexes() {
        return ingredients_indexes;
    }

    public void setIngredients_indexes(ArrayList<Integer> ingredients_indexes) {
        this.ingredients_indexes = ingredients_indexes;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ShoppingCart)) {
            return false;
        }
        ShoppingCart other = (ShoppingCart) obj;
        return (recipe_index==other.getRecipe_index());
    }
}
