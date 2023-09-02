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


            ArrayList<Integer> idxList = new ArrayList<>();

            for (int j = 0; j < foods.size(); j++) { // 사과 3개를 전부 픽해서 옴
                if (foods.get(j).getName().equals(m.getKey())) {
                    result.add(new Food(m.getKey(), foods.get(j).getPrice())); // 장바구니에 , 사과 | 사과의 가격  담아줄꺼임 ,
                    idxList.add(j);
                }

                // TODO 수량보다 적으면 Exception 터치기
                if (idxList.size() == m.getValue()) {
                    break;
                }
            }

            for (int j = 0; j < idxList.size(); j++) {
                foods.remove(idxList.get(j)); // 식품 매대에서 물건 삭제
            }


        }

        return result;

    }


    // TODO 장바구니에 담은 Food 삭제 구현
}
