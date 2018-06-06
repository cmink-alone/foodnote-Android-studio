package com.example.trio.foodnote.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
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
 * Created by ASUS on 24/04/2018.
 */

public class ShoppingIngredientAdapter extends RecyclerView.Adapter<ShoppingIngredientAdapter.ViewHolder> {
    public Context context;
    public ArrayList<Ingredient> ingredients;
    public Recipe recipe;

    public ShoppingIngredientAdapter(Context context, ArrayList<Ingredient> ingredients, int rec_index) {
        this.context = context;
        this.ingredients = ingredients;
        this.recipe = RecipeData.getData(this.context).get(rec_index);
    }

    @Override
    public ShoppingIngredientAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_ingredient, parent, false);
        ShoppingIngredientAdapter.ViewHolder vh = new ShoppingIngredientAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ShoppingIngredientAdapter.ViewHolder holder, int position) {
        Ingredient ingredient = ingredients.get(position);
        holder.tv_ingredient.setText(this.recipe.getIngredients().get(ingredient.getIndex()));
        if(ingredient.isBought()){
            holder.tv_ingredient.setPaintFlags(holder.tv_ingredient.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            holder.tv_ingredient.setTextColor(Color.RED);
            holder.iv_ingredient.setImageResource(R.drawable.ic_done);
            holder.iv_ingredient.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
        } else {
            holder.tv_ingredient.setTextColor(Color.BLACK);
            holder.tv_ingredient.setPaintFlags(holder.tv_ingredient.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.iv_ingredient.setImageResource(R.drawable.ic_remove);
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

            itemView.setOnClickListener(new ShoppingIngredientAdapter.ViewHolder.IngredientClickListener());
        }

        public class IngredientClickListener implements View.OnClickListener{
            @Override
            public void onClick(View view) {
                Integer ing_index = getAdapterPosition();
                Ingredient ingredient = ingredients.get(ing_index);
                if(ingredient.isBought()){
                    ingredient.setBought(false);
                } else {
                    ingredient.setBought(true);
                }
                notifyDataSetChanged();
            }
        }
    }
}
