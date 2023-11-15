package christmas.views;

import christmas.Event;
import christmas.EventPlanner;
import christmas.Order;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {
    private final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    public void printWelcome() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printBenefitsInfo(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
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

    public void printGiftMenu(List<Event> appliedEvents) {
        System.out.println("<증정 메뉴>");
        for (Event event : appliedEvents) {
            if (event.getEventType() == EventPlanner.EventType.GiftEvent) {
                System.out.println("샴페인 1개\n"); // 하드 코딩 말고 구현할 수 있는 방법은 더 없을까...
                return;
            }
        }
        System.out.println("없음\n");
    }

    private String convertNumberToAmountFormattedString(int number) {
        return NumberFormat.getInstance().format(number);
    }
}
