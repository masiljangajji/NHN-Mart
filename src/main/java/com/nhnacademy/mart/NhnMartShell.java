package com.nhnacademy.mart;

import java.util.Scanner;

public class NhnMartShell {

    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

//        // TODO 본인이름 영어로 변수명 작성!
//        // 본인이름을 각자 맞게 영어로 변경
//        // 홍길동 학생
//        // -> hongGilDong or gilDong
//        Customer 본인이름 = new Customer(buyList);
//
//        // 장바구니를 챙긴다.
//        본인이름.bring(mart.provideBasket());
//
//        // 식품을 담는다.
//        본인이름.pickFoods(mart.getFoodStand());
//
//        // 카운터에서 계산한다.
//        본인이름.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기

        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");

        Scanner sc = new Scanner(System.in);

        BuyList buyList = new BuyList();

        String name;
        int amount;
        String flag;

        while (true) {
            System.out.print("물건의 이름을 입력해 주세요 : ");
            name = sc.nextLine();
            System.out.print("수량을 입력해 주세요 : ");
            amount = sc.nextInt();
            sc.nextLine();
            buyList.add(new BuyList.Item(name, amount));
            System.out.println("물건을 더 고르려면 1을 아니라면 0을 입력해 주세요");

            flag = sc.nextLine();
            if (flag.equals("0")) {
                break;
            }
        }

        return buyList;
    }
}
