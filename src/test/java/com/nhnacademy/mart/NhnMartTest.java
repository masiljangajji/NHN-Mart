package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NhnMartTest {


    NhnMart nhnMart;
    BuyList buyList;
    BuyList buyList2;
    BuyList buyList3;

    BuyList buyList4;

    Customer customer;


    @BeforeEach
    void setFoodStand() {

        nhnMart = new NhnMart();
        nhnMart.prepareMart();

        buyList = new BuyList(); // 정상작동
        buyList.add(new BuyList.Item("양파", 2));
        buyList.add(new BuyList.Item("계란", 1));

        buyList2 = new BuyList(); // 매대에 없는 물건
        buyList2.add(new BuyList.Item("바나나", 2));
        buyList2.add(new BuyList.Item("양파", 1));
        buyList2.add(new BuyList.Item("계란", 2));

        buyList3 = new BuyList(); // 매대에 있는 것 보다 더 많은 물건
        buyList3.add(new BuyList.Item("양파", 100));

        buyList4 = new BuyList();// 사용자 금액을 초과 할 경우
        buyList4.add(new BuyList.Item("계란", 5));

    }

    @Test
    @DisplayName("prepareMart postCondition Test 이름 확인")
    void prepareMartTest() {


        int count1 = 0;
        int count2 = 0;

        Stream<Food> stream = nhnMart.getFoodStand().getFoods().stream();
        Stream<Food> stream2 = nhnMart.getFoodStand().getFoods().stream();


        count1 = (int) stream.filter(x -> x.getName().equals("양파")).count();
        count2 = (int) stream2.filter(x -> x.getName().equals("계란")).count();

        Assertions.assertEquals(count1, 2);
        Assertions.assertEquals(count2, 5);
    }

    @Test
    @DisplayName("prepareMart postCondition Test 이름 및 가격 확인 ")
    void prepareMartTest2() {

        int count1 = 0;
        int count2 = 0;

        Stream<Food> stream = nhnMart.getFoodStand().getFoods().stream();
        Stream<Food> stream2 = nhnMart.getFoodStand().getFoods().stream();


        count1 = (int) stream.filter(x -> x.getPrice() == 1000)
                .filter(x -> x.getName().equals("양파")).count();
        count2 = (int) stream2.filter(x -> x.getPrice() == 2000)
                .filter(x -> x.getName().equals("사과")).count();

        Assertions.assertEquals(count1, 2);
        Assertions.assertEquals(count2, 20);
    }

    @Test
    @DisplayName("prepareMart postCondition Test 가격 확인")
    void prepareMartTest3() {

        int count1 = 0;
        int count2 = 0;


        Stream<Food> stream = nhnMart.getFoodStand().getFoods().stream();
        Stream<Food> stream2 = nhnMart.getFoodStand().getFoods().stream();


        count1 = (int) stream.filter(x -> x.getPrice() == 1000).count();
        count2 = (int) stream2.filter(x -> x.getPrice() == 2000).count();

        Assertions.assertEquals(count1, 2);
        Assertions.assertEquals(count2, 20);
    }

    @Test
    @DisplayName("pickFood Test 물품과 개수가 식품 매대와 충분한 경우")
    void pickFoodTest() {

        customer = new Customer(buyList);
        customer.bring(nhnMart.provideBasket());

        customer.pickFoods(nhnMart.getFoodStand()); // 내가 고른 물품들이 그대로 basket에

        Iterator<BuyList.Item> iterator = buyList.getItems().iterator(); // 바이리스트

        // 바이 리스트랑 똑같으면 됨

        int count = 0;

        ArrayList<Food> myBasket = customer.getBasket().getBasketList();


        while (iterator.hasNext()) {
            BuyList.Item item = iterator.next();

            for (int i = 0; i < myBasket.size(); i++) {// 바이리스트에 있는 이름과 같으면 count
                if (myBasket.get(i).getName().equals(item.getName())) {
                    count++; // 이름이 같은거 전부 체크
                }
            }
        }

        Assertions.assertEquals(count, myBasket.size());

    }

    @Test
    @DisplayName("pickFood Test 매대에 물건이 buyList에 보다 적은 경우")
    void pickFoodTest2() {

        customer = new Customer(buyList3);
        customer.bring(nhnMart.provideBasket());

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customer.pickFoods(nhnMart.getFoodStand()));


        try {
            customer.pickFoods(nhnMart.getFoodStand());
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "양파 은(는) 매대에 수량이 부족합니다.");
        }

    }

    @Test
    @DisplayName("pickFood Test buyList에 물건이 매대에 없는 경우")
    void pickFoodTest3() {

        customer = new Customer(buyList2);
        customer.bring(nhnMart.provideBasket());

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customer.pickFoods(nhnMart.getFoodStand()));

        try {
            customer.pickFoods(nhnMart.getFoodStand());
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "바나나 은(는) 매대에 없는 물품입니다.");
        }


    }

    @Test
    @DisplayName(" payTox Test  갖고 있는 금액을 초과할 경우")
    void payToxTest() {

        customer = new Customer(buyList4);
        customer.bring(nhnMart.provideBasket());
        customer.pickFoods(nhnMart.getFoodStand());

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customer.payTox(nhnMart.getCounter()));


        try {
            customer.payTox(nhnMart.getCounter());
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "식품 금액의 총 합이 사용자의 잔액보다 큽니다.");
        }


    }


}