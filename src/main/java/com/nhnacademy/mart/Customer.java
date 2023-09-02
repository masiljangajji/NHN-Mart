package com.nhnacademy.mart;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) {

        // basket에 음식 넣으럮임 , add Food 할꺼임

        // foodStand 에서 food를 찾을 꺼야
            for (int i = 0; i < buyList.getItems().size(); i++) {


                // food 찾아서 , 가격 넣는거 까지만
                BuyList.Item item = buyList.getItems().get(i); // 내가 살 물건과 , 그 숫자가 있음

                Food food = foodStand.findFood(item.getName());

                basket.add(new Food(item.getName(), food.getPrice()*item.getAmount())); // 내가 살 물건과 , 그 가격을 장바구니에 넣어야 함


            }
        }


    }


    // TODO payTox 메서드 구현


}
