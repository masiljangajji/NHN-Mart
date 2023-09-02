package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 장바구니 cost의 계산이 일어나는 Calss 입니다.
 */
public class Counter {

    private static final Logger logger = LoggerFactory.getLogger(Counter.class);


    public int pay(int amountMoneny, Basket basket) {

        ArrayList<Food> basketList = basket.getBasketList();

        int totalBasketCost = 0;


        for (int i = 0; i < basketList.size(); i++) {
            totalBasketCost += basketList.get(i).getPrice();
            if (amountMoneny < totalBasketCost) {
                logger.warn("사용자가 가진 돈보다 더 큰 장바구니 금액");
                throw new IllegalArgumentException("장바구니 금액 총 합이 사용자의 잔액보다 큽니다.");
            }
        }

        return totalBasketCost;
    }

}
