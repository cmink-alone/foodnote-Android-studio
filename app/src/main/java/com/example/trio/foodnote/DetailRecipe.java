package com.example.trio.foodnote;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trio.foodnote.adapter.IngredientAdapter;
import com.example.trio.foodnote.model.Recipe;
import com.example.trio.foodnote.utilities.FavouriteData;
import com.example.trio.foodnote.utilities.RecipeData;

import java.util.ArrayList;

public class DetailRecipe extends AppCompatActivity {
    private ImageView iv_recipe;
    private TextView tv_recipe_name;
    private TextView tv_duration;
    private RecyclerView rv_ingredients;
    private TextView tv_procedures;
    private IngredientAdapter ingredientAdapter;
    private ImageView iv_share;
    private ImageView iv_fav;
    public Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recipe);

        Intent intent = getIntent();
        recipe = (Recipe) intent.getSerializableExtra("RecipeExtra");

        iv_recipe = (ImageView) findViewById(R.id.iv_recipe);
        tv_recipe_name = (TextView) findViewById(R.id.tv_recipe_name);
        tv_duration = (TextView) findViewById(R.id.tv_duration);
        rv_ingredients = (RecyclerView) findViewById(R.id.rv_ingredients);
        tv_procedures = (TextView) findViewById(R.id.tv_procedures);
        iv_share = (ImageView) findViewById(R.id.iv_share);
        iv_fav = (ImageView) findViewById(R.id.iv_fav);

        iv_recipe.setImageResource(recipe.getImg_preview());
        tv_recipe_name.setText(recipe.getName());
        tv_duration.setText(recipe.getDuration());
        tv_procedures.setText(recipe.getProcedures());

        setTitle(recipe.getName());

        ingredientAdapter = new IngredientAdapter(this, recipe.getIngredients());
        rv_ingredients.setFocusable(false);
        rv_ingredients.setAdapter(ingredientAdapter);
        rv_ingredients.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        iv_share.setOnClickListener(new SharedOnClickListener());
        iv_fav.setOnClickListener(new FavOnClickListener());


        ArrayList<Integer> fav_list = FavouriteData.getData();
        if(fav_list.contains(RecipeData.getData(this).indexOf(recipe))){
            iv_fav.setImageResource(R.drawable.ic_favorite);
        } else {
            iv_fav.setImageResource(R.drawable.ic_favorite_border);
        }
    }

    public String getSharedRecipeString(Recipe recipe){
        String msg;
        msg =   recipe.getName() + "\n" +
                recipe.getDuration() + "\n\n" +
                "----------------------------------------\n\n" +
                "Ingredients Required\n\n"+
                "----------------------------------------\n\n";
        for (String ingredient : recipe.getIngredients()) {
            msg += ingredient + "\n\n";
        }
        msg += "----------------------------------------\n\n" +
                "Directions to Prepare\n\n"+
                "----------------------------------------\n\n" +
                recipe.getProcedures() + "\n" +
                "----------------------------------------\n\n" +
                "Sent from Food Note app";

        return msg;
    }

    public boolean checkBackgroundFav(View view, int res){
        if(view.getBackground().getConstantState() == getResources().getDrawable(res).getConstantState()) {
            return true;
        }
        return false;
    }

    public class SharedOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String msg = getSharedRecipeString(recipe);
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "Share Recipe"));
        }
    }

    public class FavOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String msg;
            ArrayList<Integer> fav_list = FavouriteData.getData();
            Integer index = RecipeData.getData(getApplicationContext()).indexOf(recipe);
            if(fav_list.contains(index)){
                iv_fav.setImageResource(R.drawable.ic_favorite_border);
                fav_list.remove(index);
                msg="Recipe has been removed from favourite list!";
            } else {
                iv_fav.setImageResource(R.drawable.ic_favorite);
                fav_list.add(index);
                msg="Recipe has been added to favourite list!";
            }

            Snackbar.make(view, msg, Snackbar.LENGTH_SHORT)
                    .setAction("VIEW ALL", null).show();
        }
    }
}
