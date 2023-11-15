package christmas;

import java.util.Map;

public class Order {
    private Map<Menu, Integer> order;

    public Order(Map<Menu, Integer> order) {
        this.order = order;
    }
}
