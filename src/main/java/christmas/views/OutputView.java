package christmas.views;

import christmas.Order;

import java.text.NumberFormat;

public class OutputView {
    private final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    public void printWelcome() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printBenefitsInfo() {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }
    public void printOrder(Order order) {
        System.out.println("<주문 메뉴>");
        order.printOrder();
        System.out.println();
    }

    public void printTotalOrderPaymentBeforeSale(Order order) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(convertNumberToAmountFormattedString(order.getTotalOrderPayment()) + "원");
    }

    private String convertNumberToAmountFormattedString(int number) {
        return NumberFormat.getInstance().format(number);
    }
}
