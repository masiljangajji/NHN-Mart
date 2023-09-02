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


        logger.info(Message.START.getMessage());


        while (true) {

            BuyList buyList = inputBuyListFromShell();

            Customer seungJae = new Customer(buyList);

            seungJae.bring(mart.provideBasket());


            try {
                seungJae.pickFoods(mart.getFoodStand());
            } catch (IllegalArgumentException e) {
                logger.warn(e.getMessage());
                logger.info(Message.RE_PICK_FOOD.getMessage());
                continue;
            }

            // 카운터에서 계산한다.
            try {
                seungJae.payTox(mart.getCounter());
            } catch (IllegalArgumentException e) {
                logger.warn(e.getMessage());
                logger.info(Message.RE_PICK_FOOD.getMessage());
                continue;
            }

            logger.info("총 가격은 " + (20000 - seungJae.getMoney()) + "원 입니다");
            logger.info(Message.AFTER_PAY.getMessage() + seungJae.getMoney());
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
            logger.info(Message.INPUT_NAME.getMessage());
            name = sc.nextLine();

            while (true) {
                logger.info(Message.INPUT_AMOUNT.getMessage());
                try {
                    amount = sc.nextInt();
                    if (amount <= 0) {
                        throw new IllegalArgumentException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    logger.warn(Message.INPUT_AMOUNT_NOT_NUMBER.getMessage());
                    sc.nextLine();
                } catch (IllegalArgumentException e) {
                    logger.warn(Message.INPUT_AMOUNT_LESS_ZERO.getMessage());
                }
            }


            sc.nextLine();
            buyList.add(new BuyList.Item(name, amount));

            boolean check;


            while (true) {
                logger.info(Message.MORE_INPUT.getMessage());

                check = true;

                try {
                    flag = sc.nextLine();
                    if (!flag.equals("1") && !flag.equals("0")) {
                        throw new IllegalArgumentException();
                    }
                    if (flag.equals("0")) {
                        check = false;
                    }

                } catch (IllegalArgumentException e) {
                    logger.warn(Message.INPUT_ONLY_ONE_ZERO.getMessage());
                    continue;
                }
                break;
            }

            if (check == false) {
                break;
            }

        }


        return buyList;
    }
}
