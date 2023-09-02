package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 장바구니에 물품 담기 및 계산을 하는 Class입니다.
 */
public class Customer {

    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    private final BuyList buyList;

    public Basket getBasket() {
        return basket;
    }

    private Basket basket;

    private int money;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
        money = 20000;
    }

    public void bring(Basket basket) {
        this.basket = basket;
    }

    public int getMoney() {
        return this.money;
    }

    /**
     * buyList에 있는 물품들을 hashmap으로 정리합니다 , findFood 메서드 통해 장바구니를 채웁니다.
     *
     * @param foodStand 사용자의 buyList에 있는 물품들을 의미 합니다.
     */

    public void pickFoods(FoodStand foodStand) {


        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < buyList.getItems().size(); i++) {

            // food 찾아서 , 가격 넣는거 까지만
            BuyList.Item item = buyList.getItems().get(i);


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


    /**
     * 장바구니에 담은 물건들을 순차적으로 계산합니다.
     *
     * @param counter 카운터를 의미합니다 , 계산은 카운ㅌ에서 발생합니다.
     */
    public int payTox(Counter counter) {

        this.money = counter.pay(this.money, this.basket);
        return this.money;
    }


}





