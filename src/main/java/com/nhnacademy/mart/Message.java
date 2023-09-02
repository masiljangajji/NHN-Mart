package com.nhnacademy.mart;

/**
 * 출력할 문자열을 모아둔 enum Class.
 */
public enum Message {


    START("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요."),
    RE_PICK_FOOD("사고 싶은 물건을 다시 골라주세요"),
    AFTER_PAY("물건 구입 완료 | 결제 후 잔액 : "),
    INPUT_NAME("물건의 이름을 입력해 주세요 "),
    INPUT_AMOUNT("수량을 입력해 주세요 "),
    INPUT_AMOUNT_NOT_NUMBER("수량 입력은 숫자만 가능합니다."),
    INPUT_AMOUNT_LESS_ZERO("수량 입력은 0보다 커야 합니다."),
    MORE_INPUT("물건을 더 고르려면 1을 아니라면 0을 입력해 주세요"),
    INPUT_ONLY_ONE_ZERO("입력은 0 혹은 1만 가능합니다."),
    FOOD_NOT_IN_MART("매대에 없는 물품 구입"),
    BASKET_AMOUNT_MORE_THAN_MART("구입품목의 수량이 매대에 잔여 수량보다 큽니다."),
    BASKET_COST_MORE_THAN_MONEY("장바구니 금액 총 합이 사용자의 잔액보다 큽니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
