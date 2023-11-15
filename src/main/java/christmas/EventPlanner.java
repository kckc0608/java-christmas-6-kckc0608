package christmas;

import christmas.views.InputView;
import christmas.views.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventPlanner {
    public enum EventType {
        ChristmasDDaySale {
            @Override
            public String toString() {
                return "크리스마스 디데이 할인";
            }
        },
        WeekdaySale {
            @Override
            public String toString() {
                return "평일 할인";
            }
        },
        WeekendSale {
            @Override
            public String toString() {
                return "주말 할인";
            }
        },
        SpecialSale {
            @Override
            public String toString() {
                return "특별 할인";
            }
        },
        GiftEvent {
            @Override
            public String toString() {
                return "증정 이벤트";
            }
        }
    }

    private final int orderDate;
    private final Order order;
    private final List<Event> appliedEvents = new ArrayList<>();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public EventPlanner() {
        initPlanner();
        outputView.printWelcome();
        orderDate = inputView.readDate();
        order = inputView.readOrder();
        outputView.printBenefitsInfo(orderDate);
        outputView.printOrder(order);
        outputView.printTotalOrderPaymentBeforeSale(order);
        applyEvent();
        outputView.printGiftMenu(appliedEvents);
        outputView.printAppliedEvents(appliedEvents);
        outputView.printTotalAppliedEventsAmount(appliedEvents);
    }

    private void initPlanner() {
        appliedEvents.clear();
        MenuBoard.clearBoard();

        MenuBoard.addNewMenu("양송이수프", new Menu("양송이수프", 6000, Menu.Type.APPETIZER));
        MenuBoard.addNewMenu("타파스", new Menu("타파스", 5500, Menu.Type.APPETIZER));
        MenuBoard.addNewMenu("시저샐러드", new Menu("시저샐러드", 8000, Menu.Type.APPETIZER));

        MenuBoard.addNewMenu("티본스테이크", new Menu("티본스테이크", 55000, Menu.Type.MAIN));
        MenuBoard.addNewMenu("바비큐립", new Menu("바비큐립", 54000, Menu.Type.MAIN));
        MenuBoard.addNewMenu("해산물파스타", new Menu("해산물파스타", 35000, Menu.Type.MAIN));
        MenuBoard.addNewMenu("크리스마스파스타", new Menu("크리스마스파스타", 25000, Menu.Type.MAIN));

        MenuBoard.addNewMenu("초코케이크", new Menu("초코케이크", 15000, Menu.Type.DESERT));
        MenuBoard.addNewMenu("아이스크림", new Menu("아이스크림", 5000, Menu.Type.DESERT));

        MenuBoard.addNewMenu("제로콜라", new Menu("제로콜라", 3000, Menu.Type.DRINK));
        MenuBoard.addNewMenu("레드와인", new Menu("레드와인", 60000, Menu.Type.DRINK));
        MenuBoard.addNewMenu("샴페인", new Menu("샴페인", 25000, Menu.Type.DRINK));
    }

    private void applyEvent() {
        int totalOrderPayment = order.getTotalOrderPayment();
        if (totalOrderPayment < 10000) {
            return;
        }

        if (1 <= this.orderDate && orderDate <= 25) {
            applyChristmasDDaySaleEvent();
        }

        if (totalOrderPayment >= 120000) {
            applyGiftEvent();
        }

        if (checkOrderDateIsSpecialDay()) {
            applySpecialSaleEvent();
        }

        applyWeekendSaleOrWeekDaySaleByOrderDate();
    }

    private void applyChristmasDDaySaleEvent() {
        int saleAmount = 1000 + (orderDate - 1)*100;
        Event event = new Event(EventType.ChristmasDDaySale, saleAmount);
        appliedEvents.add(event);
    }

    private void applyWeekendSaleOrWeekDaySaleByOrderDate() {
        if (checkOrderDateIsWeekend()) {
            applyWeekendSaleEvent();
            return;
        }
        applyWeekDaySaleEvent();
    }

    private boolean checkOrderDateIsWeekend() {
        List<Integer> weekendDates = List.of(1,2,8,9,15,16,22,23,29,30);
        return weekendDates.contains(orderDate);
    }

    private void applyWeekDaySaleEvent() {
        int saleAmount = 0;
        Map<Menu, Integer> order = this.order.getOrder();
        for (Menu menu : order.keySet()) {
            if (menu.getType() == Menu.Type.DESERT) {
                saleAmount += (2023*order.get(menu));
            }
        }

        Event weekDaySaleEvent = new Event(EventType.WeekdaySale, saleAmount);
        appliedEvents.add(weekDaySaleEvent);
    }

    private void applyWeekendSaleEvent() {
        int saleAmount = 0;
        Map<Menu, Integer> order = this.order.getOrder();
        for (Menu menu : order.keySet()) {
            if (menu.getType() == Menu.Type.MAIN) {
                saleAmount += (2023*order.get(menu));
            }
        }

        Event weekendSaleEvent = new Event(EventType.WeekendSale, saleAmount);
        appliedEvents.add(weekendSaleEvent);
    }

    private void applySpecialSaleEvent() {
        appliedEvents.add(new Event(EventType.SpecialSale, 1000));
    }

    private boolean checkOrderDateIsSpecialDay() {
        List<Integer> specialDates = List.of(3, 10, 17, 24, 25, 31);
        return specialDates.contains(orderDate);
    }

    private void applyGiftEvent() {
        int champagnePrice = MenuBoard.getMenuByName("샴페인").getPrice();
        Event giftEvent = new Event(EventType.GiftEvent, champagnePrice);
        appliedEvents.add(giftEvent);
    }
}
