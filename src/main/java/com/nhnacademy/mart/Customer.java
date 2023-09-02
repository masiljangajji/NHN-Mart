package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {

    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    // 고객 구매 목록
    private final BuyList buyList;

    public Basket getBasket() {
        return basket;
    }

    // 고객 장바구니
    private Basket basket;

    private int money;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
        money = 20000;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    public int getMoney() {
        return this.money;
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) { // 내가 고른 물품들 그대로 basket에 존재

        // basket에 음식 넣으럮임 , add Food 할꺼임

        // foodStand 에서 food를 찾을 꺼야

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < buyList.getItems().size(); i++) {

            // food 찾아서 , 가격 넣는거 까지만
            BuyList.Item item = buyList.getItems().get(i); // 내가 살 물건과 , 그 숫자가 있음


            if (hashMap.get(item.getName()) == null) {
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

    public void payTox(Counter counter) {

        ArrayList<Food> basketList = basket.getBasketList();

        for (int i = 0; i < basketList.size(); i++) {
            this.money = counter.pay(this.money, basketList.get(i).getPrice());
            if (this.money < 0) {
                logger.warn("사용자가 가진 돈보다 더 큰 식품 금액");
                throw new IllegalArgumentException("식품 금액의 총 합이 사용자의 잔액보다 큽니다.");
            }
        }
    }


}





