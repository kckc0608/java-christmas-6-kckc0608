package christmas;

public class Event {
    private Order order;
    private int orderDate;

    private int saleAmount = 0;
    private int giftAmount = 0;

    public Event(Order order, int orderDate) {
        this.order = order;
        this.orderDate = orderDate;
    }

    public void applyEvent() {
        if (1 <= orderDate && orderDate <= 25) {
            applyChristmasDDaySaleEvent();
        }
    }

    private void applyChristmasDDaySaleEvent() {

    }

    private void applyWeekDaySaleEvent() {

    }

    private void applyWeekendSaleEvent() {

    }

    private void applySpecialSaleEvent() {

    }

    private void applyGiftEvent() {

    }
}
