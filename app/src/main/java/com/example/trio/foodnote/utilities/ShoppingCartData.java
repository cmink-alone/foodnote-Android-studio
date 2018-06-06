package com.example.trio.foodnote.utilities;

import com.example.trio.foodnote.model.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 19/04/2018.
 */

public class ShoppingCartData {
    private static ShoppingCartData obj = null;
    private Map<Integer, ArrayList<Ingredient>> shoppingList = new HashMap<>();

    public static Map<Integer, ArrayList<Ingredient>> getData(){
        if(ShoppingCartData.obj == null) {
            ShoppingCartData.obj = new ShoppingCartData();
        }
        return obj.shoppingList;
    }
}
