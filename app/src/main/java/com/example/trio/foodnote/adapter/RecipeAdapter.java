package com.example.trio.foodnote.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trio.foodnote.DetailRecipe;
import com.example.trio.foodnote.R;
import com.example.trio.foodnote.model.Recipe;

import java.util.List;

/**
 * Created by ASUS on 09/04/2018.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    Context context;
    List<Recipe> recipes;
    int layout_id;

    public RecipeAdapter(Context context, List<Recipe> recipes, int layout_id) {
        this.context = context;
        this.recipes = recipes;
        this.layout_id = layout_id;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(layout_id,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        holder.tv_recipe_name.setText(recipe.getName());
        holder.tv_duration.setText(recipe.getDuration());
        holder.iv_thumbnail.setImageResource(recipe.getImg_preview());
    }

    @Override
    public int getItemCount() {
        return recipes.size();
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
                    Intent detail_recipe = new Intent(view.getContext(), DetailRecipe.class);
                    detail_recipe.putExtra("RecipeExtra", recipes.get(position));
                    view.getContext().startActivity(detail_recipe);
                }
            });
        }
    }
}
