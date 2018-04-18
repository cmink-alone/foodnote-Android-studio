package com.example.trio.foodnote.utilities;

import java.util.ArrayList;

/**
 * Created by ASUS on 12/04/2018.
 */

public class FavouriteData {
    private static FavouriteData obj = null;
    private ArrayList<Integer> indexes = new ArrayList<>();

    public static ArrayList<Integer> getData(){
        if(FavouriteData.obj == null) {
            FavouriteData.obj = new FavouriteData();
        }
        return obj.indexes;
    }
}
