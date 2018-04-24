package com.example.trio.foodnote.utilities;

import com.example.trio.foodnote.model.ShoppingCart;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 19/04/2018.
 */

public class ShoppingCartData {
    private static ShoppingCartData obj = null;
    private ArrayList<ShoppingCart> shoppingCarts = new ArrayList<>();
    private Map<Integer, ArrayList<Integer>> shoppingList = new HashMap<>();

    public static Map<Integer, ArrayList<Integer>> getData(){
        if(ShoppingCartData.obj == null) {
            ShoppingCartData.obj = new ShoppingCartData();
        }
        return obj.shoppingList;
    }
}
