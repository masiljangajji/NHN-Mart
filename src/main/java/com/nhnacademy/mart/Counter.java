package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * 장바구니 cost의 계산이 일어나는 Calss 입니다.
 */
public class Counter {

    public int pay(Basket basket) {

        ArrayList<Food> basketList = basket.getBasketList();

        int totalBasketCost = 0;


        for (int i = 0; i < basketList.size(); i++) {
            totalBasketCost += basketList.get(i).getPrice();
        }

        return totalBasketCost;
    }

}
