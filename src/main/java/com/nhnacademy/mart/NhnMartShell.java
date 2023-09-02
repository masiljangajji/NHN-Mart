package com.nhnacademy.mart;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main이 되는 Class 입니다.
 * 전체적인 게임의 진행이 이루어 집니다.
 * 발생할 수 있는 Exception : {IllegalArgumentException} , {}InputMismatchException}.
 */
public class NhnMartShell {

    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);

    /**
     * main 메서드 입니다.
     */
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        Scanner sc = new Scanner(System.in);

        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");


        while (true) {

            BuyList buyList = inputBuyListFromShell();

            Customer seungJae = new Customer(buyList);

            seungJae.bring(mart.provideBasket());


            try {

                seungJae.pickFoods(mart.getFoodStand());
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
                System.out.println(" 사고 싶은 물건을 다시 골라주세요\n");
                continue;
            }

            // 카운터에서 계산한다.
            try {
                seungJae.payTox(mart.getCounter());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("사고 싶은 물건을 다시 골라주세요\n");
                continue;
            }

            System.out.println("물건 구입 완료 | 남은 금액 : " + seungJae.getMoney());

            System.out.println("물건구입이 끝났습니다. ");
            break;

        }


    }

    private static BuyList inputBuyListFromShell() {


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
