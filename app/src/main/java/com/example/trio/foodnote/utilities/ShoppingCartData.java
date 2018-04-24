package com.example.trio.foodnote.utilities;

import com.example.trio.foodnote.model.ShoppingCart;

import java.util.ArrayList;

/**
 * Created by ASUS on 19/04/2018.
 */

public class ShoppingCartData {
    private static ShoppingCartData obj = null;
    private ArrayList<ShoppingCart> shoppingCarts = new ArrayList<>();

    public static ArrayList<ShoppingCart> getData(){
        if(ShoppingCartData.obj == null) {
            ShoppingCartData.obj = new ShoppingCartData();
        }
        return obj.shoppingCarts;
    }
}
