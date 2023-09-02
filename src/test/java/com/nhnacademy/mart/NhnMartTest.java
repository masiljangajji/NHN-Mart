package com.nhnacademy.mart;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NhnMartTest {


    private final FoodStand foodStand = new FoodStand();


    @BeforeEach
    void setFoodStand() {
        foodStand.add(new Food("바나나", 1000));
        foodStand.add(new Food("바나나", 1000));
        foodStand.add(new Food("키위", 2000));
    }

    @Test
    @DisplayName("prepareMart postCondition Test 이름 확인")
    void prepareMartTest() {


        int count1 = 0;
        int count2 = 0;

        Stream<Food> stream = foodStand.getFoods().stream();

        count1 = (int) foodStand.getFoods().stream().filter(x -> x.getName().equals("바나나")).count();
        count2 = (int) foodStand.getFoods().stream().filter(x -> x.getName().equals("키위")).count();

        Assertions.assertEquals(count1, 2);
        Assertions.assertEquals(count2, 1);
    }

    @Test
    @DisplayName("prepareMart postCondition Test2 가격 확인")
    void prepareMartTest2() {

        int count1 = 0;
        int count2 = 0;

        Stream<Food> stream = foodStand.getFoods().stream();

        count1 = (int) foodStand.getFoods().stream().filter(x -> x.getPrice() == 1000).count();
        count2 = (int) foodStand.getFoods().stream().filter(x -> x.getPrice() == 2000).count();

        Assertions.assertEquals(count1, 2);
        Assertions.assertEquals(count2, 1);
    }


}