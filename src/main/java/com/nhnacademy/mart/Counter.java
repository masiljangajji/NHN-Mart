package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 장바구니 cost의 계산이 일어나는 Calss 입니다.
 */
public class Counter {

    private static final Logger logger = LoggerFactory.getLogger(Counter.class);

    /**
     * 장바구니에 담은 물건을 계산하는 메서드 .
     *
     * @param amountMoneny 사용자가 가진 돈을 의미함.
     * @param basket       장바구니를 의미함.
     * @return 장바구니 금액을 제외한 돈을 반환 , 장바구니에 담은 금액이 더 클 경우 예외처리
     */
    public int pay(int amountMoneny, Basket basket) {

        ArrayList<Food> basketList = basket.getBasketList();

        int totalBasketCost = 0;


        for (int i = 0; i < basketList.size(); i++) {
            totalBasketCost += basketList.get(i).getPrice();
            if (amountMoneny < totalBasketCost) {
                throw new IllegalArgumentException(Message.BASKET_COST_MORE_THAN_MONEY.getMessage());
            }
        }

        return amountMoneny - totalBasketCost;
    }

}
