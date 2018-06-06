package com.example.trio.foodnote.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
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
 * Created by ASUS on 10/04/2018.
 */

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {
    public Context context;
    public List<String> ingredients;
    public Map<Integer, ArrayList<Ingredient>> shoppingCarts;
    public Recipe recipe;
    public int rec_index;

    public IngredientAdapter(Context context, List<String> ingredients) {
        this.context = context;
        this.ingredients = ingredients;
        this.shoppingCarts = ShoppingCartData.getData();
        this.recipe = ((DetailRecipe)context).getRecipe();
        this.rec_index = RecipeData.getData(context).indexOf(this.recipe);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_ingredient, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_ingredient.setText(ingredients.get(position));
        Integer ing_index = position;
        Ingredient ingredient = new Ingredient(ing_index, false);
        ArrayList<Ingredient> ingredients;
        if(shoppingCarts.containsKey(rec_index)){
            ingredients = shoppingCarts.get(rec_index);
            if(ingredients.contains(ingredient)){
                holder.iv_ingredient.setImageResource(R.drawable.ic_check_circle);
                holder.iv_ingredient.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
            } else {
                holder.iv_ingredient.setImageResource(R.drawable.ic_add_circle);
                holder.iv_ingredient.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary), android.graphics.PorterDuff.Mode.SRC_IN);
            }
        } else {
            holder.iv_ingredient.setImageResource(R.drawable.ic_add_circle);
            holder.iv_ingredient.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary), android.graphics.PorterDuff.Mode.SRC_IN);
        }
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_ingredient;
        public TextView tv_ingredient;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_ingredient = (ImageView) itemView.findViewById(R.id.iv_ingredient);
            tv_ingredient = (TextView) itemView.findViewById(R.id.tv_ingredient);
            context = itemView.getContext();

            itemView.setOnClickListener(new IngredientClickListener());
        }

        public class IngredientClickListener implements View.OnClickListener{
            @Override
            public void onClick(View view) {
                Integer ing_index = getAdapterPosition();
                Ingredient ingredient = new Ingredient(ing_index, false);
                ArrayList<Ingredient> ingredients;
                String msg ="";

                if(shoppingCarts.containsKey(rec_index)){
                    ingredients = shoppingCarts.get(rec_index);
                    if(ingredients.contains(ingredient)){
                        //delete
                        ingredients.remove(ingredient);
                        msg = "Ingredient has been removed from shopping cart!";
                    } else {
                        //add new to the existing
                        ingredients.add(ingredient);
                        msg = "Ingredient has been added to shopping cart!";
                    }
                } else {
                    ingredients = new ArrayList<>();
                    ingredients.add(ingredient);
                    shoppingCarts.put(rec_index, ingredients);
                    msg = "Ingredient has been added to shopping cart!";
                }

                notifyDataSetChanged();

                Snackbar.make(view, msg, Snackbar.LENGTH_SHORT)
                        .setAction("VIEW ALL", null).show();
            }
        }
    }
}
