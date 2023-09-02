package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * 장바구니를 정의하는 Class 입니다.
 */
public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Item을 정의합니다 , {이름|수량} 으로 정의됩니다.
     */
    public static class Item {
        private final String name;
        private final int amount;


        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }
}
