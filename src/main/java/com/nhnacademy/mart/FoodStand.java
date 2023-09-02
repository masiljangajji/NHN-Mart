package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 마트의 식품 매대를 이용해 장바구니에 물품을 넣습니다.
 */
public class FoodStand {


    private static final Logger logger = LoggerFactory.getLogger(FoodStand.class);

    public ArrayList<Food> getFoods() {
        return foods;
    }

    private final ArrayList<Food> foods = new ArrayList<>();


    public void add(Food food) {
        foods.add(food);
    }


    /**
     * buyList에 있는 물품과 마트의 식품 매대에 물품들을 확인해 장바구니에 담습니다.
     *
     * @param hashMap 사용자의 buyList에 있는 물품들을 의미 합니다.
     * @return 메소드 정상 수행 성공 시 장바구니에 buyList 물품을 반환합니다 , 그 외엔 예외를 반환합니다.
     */
    public ArrayList<Food> findFood(HashMap<String, Integer> hashMap) {


        Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
        ArrayList<Food> result = new ArrayList<>();


        while (iterator.hasNext()) {

            Map.Entry<String, Integer> m = iterator.next();


            ArrayList<Integer> idxList = new ArrayList<>();

            boolean flag = true;

            for (int j = 0; j < foods.size(); j++) {
                if (foods.get(j).getName().equals(m.getKey())) {
                    result.add(new Food(m.getKey(), foods.get(j).getPrice()));
                    idxList.add(j);
                }

                if (idxList.size() == m.getValue()) {
                    break;
                }
            }

            if (idxList.isEmpty()) {
                throw new IllegalArgumentException(m.getKey() + " 은(는) 매대에 없는 물품입니다.");
            }

            if (idxList.size() < m.getValue()) {
                throw new IllegalArgumentException(m.getKey() + " 은(는) 매대에 수량이 부족합니다.");
            }

            for (int j = 0; j < idxList.size(); j++) {
                foods.remove(idxList.get(j));
            }


        }

        return result;

    }


}
