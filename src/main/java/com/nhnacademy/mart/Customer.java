package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) {

        // basket에 음식 넣으럮임 , add Food 할꺼임

        // foodStand 에서 food를 찾을 꺼야

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < buyList.getItems().size(); i++) {

            // food 찾아서 , 가격 넣는거 까지만
            BuyList.Item item = buyList.getItems().get(i); // 내가 살 물건과 , 그 숫자가 있음


            if (hashMap.get(item.getName()).equals(null)) {
                hashMap.put(item.getName(), item.getAmount());
            } else {
                hashMap.put(item.getName(), hashMap.get(item.getName()) + item.getAmount());
            }
        }

        ArrayList<Food> result = foodStand.findFood(hashMap);

        for (int i = 0; i < result.size(); i++) {
            basket.add(result.get(i));
        }
    }


    // TODO payTox 메서드 구현


}





