package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현

    public void add(Food food) {
        foods.add(food);
    }

    public int findFood(String foodName, int amount) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < foods.size(); i++) {

            Food food = foods.get(i);

            if (foodName.equals(food.getName())) { // foodStand 에 있는 물건 , 수량만큼 지워줘야 함
                list.add(i); // idx 저장  , 후에 지워주면 됨
            }
        }

        // TODO 수량보다 적으면 Exception 터치기 list.size()< amount


        int result = 0;

        // remove 시키고 , 남은 용량만큼 넣어주면 된다 .
        for (int i = 0; i < list.size(); i++) {

            int numidx = list.get(i);

            result += foods.get(numidx).getPrice();
            foods.remove(list.get(i));
        }

        return result;

    }


    // TODO 장바구니에 담은 Food 삭제 구현
}
