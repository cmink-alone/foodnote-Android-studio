package com.example.trio.foodnote.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trio.foodnote.R;

import java.util.List;

/**
 * Created by ASUS on 08/04/2018.
 */

public class LabelAdapter extends RecyclerView.Adapter<LabelAdapter.ViewHolder> {
    Context context;
    List<String> labels;

    public LabelAdapter(Context context, List<String> labels) {
        this.context = context;
        this.labels = labels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_label, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String label = labels.get(position);
        holder.tv_label.setText(label);
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_label;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_label = (TextView) itemView.findViewById(R.id.tv_label);
        }
    }
}
