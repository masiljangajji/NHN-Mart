package com.nhnacademy.mart;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NhnMartShell {

    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);


    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        Scanner sc = new Scanner(System.in);

        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");


        while (true) {

            BuyList buyList = inputBuyListFromShell();

            // TODO 본인이름 영어로 변수명 작성!
            // 본인이름을 각자 맞게 영어로 변경
            // 홍길동 학생
            // -> hongGilDong or gilDong

            Customer seungJae = new Customer(buyList);

            // 장바구니를 챙긴다.
            seungJae.bring(mart.provideBasket());

            // 식품을 담는다.
            try {
                seungJae.pickFoods(mart.getFoodStand());
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
                System.out.println(" 사고 싶은 물건을 다시 골라주세요");
                System.out.println();
                continue;
            }

            // 카운터에서 계산한다.
            seungJae.payTox(mart.getCounter());

            System.out.println(seungJae.getMoney());


            System.out.println("쇼핑이 끝났습니다. ");
            break;

        }


    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기


        Scanner sc = new Scanner(System.in);

        BuyList buyList = new BuyList();

        String name;
        int amount = 0;
        String flag;

        while (true) {
            System.out.print("물건의 이름을 입력해 주세요 : ");
            name = sc.nextLine();

            while (true) {
                System.out.print("수량을 입력해 주세요 : ");
                try {
                    amount = sc.nextInt();
                    if (amount == 0) {
                        throw new IllegalArgumentException("수량 입력은 0보다 커야합니다.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    logger.warn("숫자가 아닌 수량 입력");
                    System.out.println("수량 입력은 숫자만 가능합니다.");
                    sc.nextLine();
                } catch (IllegalArgumentException e) {
                    logger.warn("0보다 작은 수량 입력");
                    System.out.println(e.getMessage());
                }
            }


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
