package com.example.trio.foodnote.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trio.foodnote.DetailRecipe;
import com.example.trio.foodnote.R;
import com.example.trio.foodnote.model.Ingredient;
import com.example.trio.foodnote.model.Recipe;
import com.example.trio.foodnote.utilities.RecipeData;
import com.example.trio.foodnote.utilities.ShoppingCartData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 24/04/2018.
 */

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {
    public Context context;
    public Map<Integer, ArrayList<Ingredient>> shoppingList;
    public ArrayList<Integer> recipe_ids;


    public ShoppingListAdapter(Context context, Map<Integer, ArrayList<Ingredient>> shoppingList) {
        this.context = context;
        this.shoppingList = shoppingList;
        this.recipe_ids = new ArrayList<>(shoppingList.keySet());
        Log.i("TAG", "ShoppingListAdapter: " + this.recipe_ids);
    }

    @Override
    public ShoppingListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_shopping_cart, parent, false);
        ShoppingListAdapter.ViewHolder vh = new ShoppingListAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ShoppingListAdapter.ViewHolder holder, int position) {
        int recipe_position = recipe_ids.get(position);
        ArrayList<Recipe> recipes = RecipeData.getData(this.context);
        Recipe recipe = recipes.get(recipe_position);
        holder.tv_recipe_name.setText(recipe.getName());

        ShoppingIngredientAdapter ingredientAdapter = new ShoppingIngredientAdapter(context, shoppingList.get(recipe_position), recipe_position);
        holder.rv_list_ingredients.setAdapter(ingredientAdapter);
        holder.rv_list_ingredients.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public int getItemCount() {
        return recipe_ids.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_recipe_name;
        public RecyclerView rv_list_ingredients;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_recipe_name = (TextView) itemView.findViewById(R.id.tv_recipe_name);
            rv_list_ingredients = (RecyclerView) itemView.findViewById(R.id.rv_list_ingredients);
        }
    }
}
