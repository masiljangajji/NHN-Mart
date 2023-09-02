package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * 장바구니를 정의합니다 , foods의 list로 정의됩니다.
 */
public class Basket {


    private final ArrayList<Food> foods = new ArrayList<>();

    public ArrayList<Food> getBasketList() {
        return foods;
    }

    public void add(Food food) {
        foods.add(food);
    }

}
