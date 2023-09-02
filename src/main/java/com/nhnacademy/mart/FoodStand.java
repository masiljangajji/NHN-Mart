package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoodStand {


    private static final Logger logger = LoggerFactory.getLogger(FoodStand.class);

    public ArrayList<Food> getFoods() {
        return foods;
    }

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현

    public void add(Food food) {
        foods.add(food);
    }

    public ArrayList<Food> findFood(HashMap<String, Integer> hashMap) {


        Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();// 바이리스트
        ArrayList<Food> result = new ArrayList<>();


        while (iterator.hasNext()) { // 사과 3개 , 바나나 5개 , 원래는 사과 사과 바나나 바나나 바나나 바나나 사과 바나나

            Map.Entry<String, Integer> m = iterator.next();


            ArrayList<Integer> idxList = new ArrayList<>();

            boolean flag = true;

            for (int j = 0; j < foods.size(); j++) { // 사과 3개를 전부 픽해서 옴
                if (foods.get(j).getName().equals(m.getKey())) {
                    result.add(new Food(m.getKey(), foods.get(j).getPrice())); // 장바구니에 , 사과 | 사과의 가격  담아줄꺼임 ,
                    idxList.add(j);
                }

                if (idxList.size() == m.getValue()) {
                    break; // 같으면 다 산거임
                }
            }

            if (idxList.isEmpty()) {
                logger.warn("매대에 없는 물품 구입");
                throw new IllegalArgumentException(m.getKey() + "은(는) 매대에 없는 물품입니다");
            }

            //  내가 살 수량보다 적은거 예외처리
            if (idxList.size() < m.getValue()) {
                // TODO 로그 찍기
                logger.warn("구입품목의 수량이 매대에 무품수량보다 큼");
                throw new IllegalArgumentException(m.getKey() + "은(는) 매대에 수량이 부족합니다.");
            }

            for (int j = 0; j < idxList.size(); j++) {
                foods.remove(idxList.get(j)); // 식품 매대에서 물건 삭제
            }


        }

        return result;

    }


}
