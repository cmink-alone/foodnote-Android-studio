package com.example.trio.foodnote.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trio.foodnote.R;

import java.util.List;

/**
 * Created by ASUS on 10/04/2018.
 */

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {
    public Context context;
    public List<String> ingredients;

    public IngredientAdapter(Context context, List<String> ingredients) {
        this.context = context;
        this.ingredients = ingredients;
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
        }
    }
}
