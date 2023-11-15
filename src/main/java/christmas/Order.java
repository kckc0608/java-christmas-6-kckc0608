package christmas;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Menu, Integer> order;

    public Order(Map<Menu, Integer> order) {
        this.order = order;
    }

    public void printOrder() {
        for (Menu orderMenu : order.keySet()) {
            System.out.println(orderMenu.getName() + " " + order.get(orderMenu) + "개");
        }
    }

    public int getTotalOrderPayment() {
        int total = 0;
        for (Menu orderMenu : order.keySet()) {
            int price = orderMenu.getPrice();
            int amount = order.get(orderMenu);
            total += price*amount;
        }
        return total;
    }

    public Map<Menu, Integer> getOrder() {
        return Map.copyOf(this.order);
    }
}
