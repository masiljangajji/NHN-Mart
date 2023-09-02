package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현

    public void add(Food food) {
        foods.add(food);
    }

    public Food findFood(String foodName) {

        for (int i = 0; i < foods.size(); i++) {

            Food food = foods.get(i);

            if (foodName.equals(food.getName())) {
                return food;
            }
        }

        throw new IllegalArgumentException(foodName + "은(는) 식품 매대에 존재하지 않습니다. ");

    }


    // TODO 장바구니에 담은 Food 삭제 구현
}
