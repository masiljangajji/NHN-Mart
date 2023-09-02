package com.nhnacademy.mart;

/**
 * 식품을 정의홥니다 , 이름과 가격으로 정의됩니다.
 */
public class Food {

    private final String name;
    private final int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
