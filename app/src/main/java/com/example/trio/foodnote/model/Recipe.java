package com.example.trio.foodnote.model;

import android.support.v4.util.ArrayMap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ASUS on 19/03/2018.
 */

public class Recipe implements Serializable {
    private int id;
    private String name;
    private String duration;
    private int serving;
    private ArrayList<String> ingredients = new ArrayList<>();
    private String procedures;
    private String contributor;
    private int img_preview;
    private ArrayList<String> labels = new ArrayList<>();

    public Recipe(int id, String name, String duration, int serving, ArrayList<String> ingredients, String procedures, String contributor, int img_preview, ArrayList<String> labels) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.serving = serving;
        this.ingredients = ingredients;
        this.procedures = procedures;
        this.contributor = contributor;
        this.img_preview = img_preview;
        this.labels = labels;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<String> labels) {
        this.labels = labels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getServing() {
        return serving;
    }

    public void setServing(int serving) {
        this.serving = serving;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public int getImg_preview() {
        return img_preview;
    }

    public void setImg_preview(int img_preview) {
        this.img_preview = img_preview;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) obj;
        return (id==other.getId());
    }
}
