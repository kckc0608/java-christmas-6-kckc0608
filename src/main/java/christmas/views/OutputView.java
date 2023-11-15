package christmas.views;

import christmas.Order;

public class OutputView {
    private final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    public void printWelcome() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printBenefitsInfo() {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }
    public void printMenu(Order order) {
        System.out.println("<주문 메뉴>");
        order.printOrder();
    }
    // ...
}
