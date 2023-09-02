package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현

    public void add(Food food) {
        foods.add(food);
    }

    public ArrayList<Food> findFood(HashMap<String, Integer> hashMap) {


        Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
        ArrayList<Food> result = new ArrayList<>();


        while (iterator.hasNext()) { // 사과 3개 , 바나나 5개 , 원래는 사과 사과 바나나 바나나 바나나 바나나 사과 바나나

            Map.Entry<String, Integer> m = iterator.next();

            int amount = m.getValue();

            for (int i = 0; i < amount; i++) { // 사과 3개

                // TODO 수량보다 적으면 Exception 터치기

                int idx = foods.indexOf(m.getKey()); // 사과 , 사과 없으면 -1 반환됨 이걸로 Exception 터치기

                int foodCost = foods.get(idx).getPrice(); // 사과 가격

                result.add(new Food(m.getKey(), foodCost)); // 장바구니에 , 사과 | 사과의 가격  담아줄꺼임 ,
                foods.remove(idx); // 식품 매대에서 물건 삭제
            }
        }

        return result;

    }


    // TODO 장바구니에 담은 Food 삭제 구현
}
