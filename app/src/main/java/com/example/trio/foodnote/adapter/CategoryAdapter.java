package com.example.trio.foodnote.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trio.foodnote.R;
import com.example.trio.foodnote.SearchActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private Context context;
    ArrayList<String> labels;
    ArrayList<Integer> images;

    public CategoryAdapter(Context context, Map<String, Integer> categories) {
        this.context = context;
        this.labels = new ArrayList<String>(categories.keySet());
        this.images = new ArrayList<Integer>(categories.values());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_category, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_thumbnail.setText(labels.get(position));
        Picasso.get().load(images.get(position))
                .placeholder(R.drawable.food_placeholder)
                .into(holder.iv_thumbnail);
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_thumbnail;
        public TextView tv_thumbnail;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_thumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tv_thumbnail = itemView.findViewById(R.id.tv_thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position  =   getAdapterPosition();

                    Intent search_activity = new Intent(v.getContext(), SearchActivity.class);
                    search_activity.putExtra("LabelExtra", labels.get(position));
                    v.getContext().startActivity(search_activity);
                }
            });
        }
    }
}
