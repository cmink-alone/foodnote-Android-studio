package com.example.trio.foodnote.utilities;

import android.content.Context;
import android.content.res.Resources;

import com.example.trio.foodnote.R;
import com.example.trio.foodnote.model.Recipe;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ASUS on 10/04/2018.
 */

public class RecipeData implements Serializable {
    private static RecipeData obj = null;
    private ArrayList<Recipe> recipes = new ArrayList<>();

    public RecipeData(Context context){

        int[] ing_ids = {
                R.array.ingredient_1,
                R.array.ingredient_2,
                R.array.ingredient_3,
                R.array.ingredient_4,
                R.array.ingredient_5,
                R.array.ingredient_6,
                R.array.ingredient_7,
                R.array.ingredient_8,
                R.array.ingredient_9,
                R.array.ingredient_10,
                R.array.ingredient_11,
                R.array.ingredient_12,
                R.array.ingredient_13,
                R.array.ingredient_14,
                R.array.ingredient_15,
                R.array.ingredient_16,
                R.array.ingredient_17,
                R.array.ingredient_18,
                R.array.ingredient_19,
                R.array.ingredient_20
        };

        int[] lbl_ids = {
                R.array.label_1,
                R.array.label_2,
                R.array.label_3,
                R.array.label_4,
                R.array.label_5,
                R.array.label_6,
                R.array.label_7,
                R.array.label_8,
                R.array.label_9,
                R.array.label_10,
                R.array.label_11,
                R.array.label_12,
                R.array.label_13,
                R.array.label_14,
                R.array.label_15,
                R.array.label_16,
                R.array.label_17,
                R.array.label_18,
                R.array.label_19,
                R.array.label_20
        };

        int[] res_ids = {
                R.drawable.food1,
                R.drawable.food2,
                R.drawable.food3,
                R.drawable.food4,
                R.drawable.food5,
                R.drawable.food6,
                R.drawable.food7,
                R.drawable.food8,
                R.drawable.food9,
                R.drawable.food10,
                R.drawable.food11,
                R.drawable.food12,
                R.drawable.food13,
                R.drawable.food14,
                R.drawable.food15,
                R.drawable.food16,
                R.drawable.food17,
                R.drawable.food18,
                R.drawable.food19,
                R.drawable.food20,
        };

        String[] names = context.getResources().getStringArray(R.array.recipe_names);
        ArrayList<String[]> ingredients = new ArrayList<>();
        String[] durations = context.getResources().getStringArray(R.array.recipe_durations);
        String[] direntions = context.getResources().getStringArray(R.array.recipe_directions);
        ArrayList<String[]> labels = new ArrayList<>();

        int i=0;
        for (int ing_id: ing_ids){
            ingredients.add(context.getResources().getStringArray(ing_id));
            labels.add(context.getResources().getStringArray(lbl_ids[i]));
            i++;
        }

        i=0;
        for (String name : names){
            ArrayList<String> ingredient_row = new ArrayList<>();
            ArrayList<String> label_row = new ArrayList<>();
            for(String ingredient: ingredients.get(i)){
                ingredient_row.add(ingredient);
            }
            for(String label: labels.get(i)){
                label_row.add(label);
            }
            recipes.add(new Recipe(
                    i,
                    name,
                    durations[i],
                    1,
                    ingredient_row,
                    direntions[i],
                    "alex",
                    res_ids[i],
                    label_row
                    )
            );
            i++;
        }

    }

    public static ArrayList<Recipe> getData(Context context){
        if(RecipeData.obj == null) {
            RecipeData.obj = new RecipeData(context);
        }
        return obj.recipes;
    }
}
