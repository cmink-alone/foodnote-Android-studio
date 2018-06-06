package com.example.trio.foodnote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.trio.foodnote.adapter.FavouriteAdapter;
import com.example.trio.foodnote.model.Recipe;
import com.example.trio.foodnote.utilities.RecipeData;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView rv_favourite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent = getIntent();
        String label = intent.getStringExtra("LabelExtra");

        setTitle(label);

        ArrayList<Recipe> recipes = RecipeData.getData(this);
        ArrayList<Integer> rec_ids = new ArrayList<>();

        int i=0;
        for (Recipe recipe : recipes) {
            if(recipe.getLabels().contains(label)){
                rec_ids.add(i);
            }
            i++;
        }

        FavouriteAdapter favouriteAdapter = new FavouriteAdapter(this, rec_ids);

        rv_favourite = findViewById(R.id.rv_favourite);
        rv_favourite.setAdapter(favouriteAdapter);
        rv_favourite.setLayoutManager(new GridLayoutManager(this, 2));
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
