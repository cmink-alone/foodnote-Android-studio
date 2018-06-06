package com.example.trio.foodnote.model;

public class Ingredient {
    private int index;
    private boolean bought;

    public Ingredient(int index, boolean bought) {
        this.index = index;
        this.bought = bought;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) obj;
        return (index==other.getIndex());
    }
}
