package christmas;

import java.util.Map;

public class Order {
    private Map<Menu, Integer> order;

    public Order(Map<Menu, Integer> order) {
        this.order = order;
    }

    public void printOrder() {
        for (Menu orderMenu : order.keySet()) {
            System.out.println(orderMenu.getName() + " " + order.get(orderMenu.getName()) + "개\n");
        }
//        타파스 1개
//        제로콜라 1개
    }
}
