package com.nhnacademy.mart;

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


    }

    @Test
    @DisplayName("prepareMart postCondition Test 이름 확인")
    void prepareMartTest() {


        int count1 = 0;
        int count2 = 0;

        Stream<Food> stream = nhnMart.getFoodStand().getFoods().stream();

        count1 = (int) stream.filter(x -> x.getName().equals("양파")).count();
        count2 = (int) stream.filter(x -> x.getName().equals("계란")).count();

        Assertions.assertEquals(count1, 2);
        Assertions.assertEquals(count2, 5);
    }

    @Test
    @DisplayName("prepareMart postCondition Test 이름 및 가격 확인 ")
    void prepareMartTest2() {

        int count1 = 0;
        int count2 = 0;

        Stream<Food> stream = nhnMart.getFoodStand().getFoods().stream();


        count1 = (int) stream.filter(x -> x.getPrice() == 1000)
                .filter(x -> x.getName().equals("양파")).count();
        count2 = (int) stream.filter(x -> x.getPrice() == 2000)
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

        count1 = (int) stream.filter(x -> x.getPrice() == 1000).count();
        count2 = (int) stream.filter(x -> x.getPrice() == 2000).count();

        Assertions.assertEquals(count1, 2);
        Assertions.assertEquals(count2, 20);
    }


}