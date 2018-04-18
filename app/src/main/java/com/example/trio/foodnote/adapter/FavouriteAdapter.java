package com.example.trio.foodnote.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trio.foodnote.DetailRecipe;
import com.example.trio.foodnote.FavouriteFragment;
import com.example.trio.foodnote.R;
import com.example.trio.foodnote.model.Recipe;
import com.example.trio.foodnote.utilities.RecipeData;

import java.util.ArrayList;

/**
 * Created by ASUS on 18/04/2018.
 */

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Integer> fav_indexes;
    private ArrayList<Recipe> recipes;

    public FavouriteAdapter(Context context, ArrayList<Integer> fav_indexes) {
        this.context = context;
        this.fav_indexes = fav_indexes;
        recipes = RecipeData.getData(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_recipe,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recipe recipe = recipes.get(fav_indexes.get(position));

        holder.tv_recipe_name.setText(recipe.getName());
        holder.tv_duration.setText(recipe.getDuration());
        holder.iv_thumbnail.setImageResource(recipe.getImg_preview());
    }

    @Override
    public int getItemCount() {
        return fav_indexes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_recipe_name;
        TextView tv_duration;
        ImageView iv_thumbnail;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_recipe_name = (TextView) itemView.findViewById(R.id.tv_recipe_name);
            tv_duration = (TextView) itemView.findViewById(R.id.tv_duration);
            iv_thumbnail = (ImageView) itemView.findViewById(R.id.iv_thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position  =   getAdapterPosition();
                    int fav_index = fav_indexes.get(position);

                    Intent detail_recipe = new Intent(view.getContext(), DetailRecipe.class);
                    detail_recipe.putExtra("RecipeExtra", recipes.get(fav_index));
                    view.getContext().startActivity(detail_recipe);
                }
            });
        }

    }
}
