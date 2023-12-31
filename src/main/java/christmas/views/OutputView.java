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
        System.out.println(convertNumberToAmountFormattedString(order.getTotalOrderPayment()) + "원\n");
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

    public void printAppliedEvents(List<Event> appliedEvents) {
        System.out.println("<혜택 내역>");
        if (appliedEvents.isEmpty()) {
            System.out.println("없음\n");
            return;
        }

        for (Event event : appliedEvents) {
            System.out.println(event.getEventType().toString() + ": -" + event.getApplyAmount() + "원");
        }
        System.out.println();
    }

    public void printTotalAppliedEventsAmount(List<Event> appliedEvents) {
        System.out.println("<총혜택 금액>");
        int totalAppliedEventsAmount = getTotalAppliedEventsAmount(appliedEvents);
        if (totalAppliedEventsAmount > 0) {
            System.out.println("-" + totalAppliedEventsAmount + "원\n");
            return;
        }
        System.out.println("0원\n");
    }

    public void printWillPaymentAfterSale(Order order, List<Event> appliedEvents) {
        int paymentAmount = order.getTotalOrderPayment();
        System.out.println("<할인 후 예상 결제 금액>");
        for (Event event : appliedEvents) {
            if (event.getEventType() == EventPlanner.EventType.GiftEvent) {
                continue;
            }
            paymentAmount -= event.getApplyAmount();
        }

        System.out.println(convertNumberToAmountFormattedString(paymentAmount) + "원\n");
    }

    public void printBadgeToGet(List<Event> appliedEvents) {
        int totalAppliedEventsAmount = getTotalAppliedEventsAmount(appliedEvents);
        System.out.println("<12월 이벤트 배지>");
        if (totalAppliedEventsAmount >= 20000) {
            System.out.println("산타");
            return;
        }
        if (totalAppliedEventsAmount >= 10000) {
            System.out.println("트리");
            return;
        }
        if (totalAppliedEventsAmount >= 5000) {
            System.out.println("별");
            return;
        }
        System.out.println("없음");
    }

    private int getTotalAppliedEventsAmount(List<Event> appliedEvents) {
        int totalAppliedEventsAmount = 0;

        for (Event event : appliedEvents) {
            totalAppliedEventsAmount += event.getApplyAmount();
        }

        return totalAppliedEventsAmount;
    }

    private String convertNumberToAmountFormattedString(int number) {
        return NumberFormat.getInstance().format(number);
    }
}
