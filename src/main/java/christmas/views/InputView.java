package christmas.views;
import camp.nextstep.edu.missionutils.Console;
import christmas.Menu;
import christmas.MenuBoard;
import christmas.Order;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        int date;
        while (true) {
            String input = Console.readLine();
            try {
                date = validateAndConvertDateInputToOrderDate(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }
        return date;
    }

    public Order readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        Map<Menu, Integer> orderMap;
        while (true) {
            try {
                String input = Console.readLine();
                orderMap = validateAndConvertInputToOrderMap(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }
        return new Order(orderMap);
    }

    private Map<Menu,Integer> validateAndConvertInputToOrderMap(String orderInput) {
        List<String> menuOrders = Arrays.stream(orderInput.split(",")).toList();
        HashMap<Menu, Integer> orderMap = new HashMap<>();
        for (String menuOrder : menuOrders) {
            List<String> order =  Arrays.stream(menuOrder.split("-")).toList();
            int menuCount = validateAndConvertMenuCountInputToInt(order.get(1));
            String menuName = order.get(0);
            Menu menu = MenuBoard.getMenuByName(menuName);
            if (orderMap.containsKey(menu)) {
                throw new IllegalArgumentException();
            }
            orderMap.put(menu, menuCount);
        }
        validateOrderMap(orderMap);
        return orderMap;
    }

    private void validateOrderMap(Map<Menu, Integer> orderMap) {
        validateOrderCountUnder20(orderMap);
        validateOrderHasNotOnlyDrink(orderMap);
    }

    private void validateOrderCountUnder20(Map<Menu, Integer> orderMap) {
        int orderCount = 0;

        for (Menu menu : orderMap.keySet()) {
            orderCount += orderMap.get(menu);
        }

        if (orderCount > 20) {
            System.out.println("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateOrderHasNotOnlyDrink(Map<Menu, Integer> orderMap) {
        boolean isOnlyDrink = true;
        for (Menu menu : orderMap.keySet()) {
            if (menu.getType() != Menu.Type.DRINK) {
                isOnlyDrink = false;
            }
        }

        if (isOnlyDrink) {
            System.out.println("[ERROR] 음료만 주문할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    private int validateAndConvertMenuCountInputToInt(String menuCountInput) {
        int menuCount;
        try {
            menuCount = Integer.parseInt(menuCountInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }

        if (menuCount < 1) {
            throw  new IllegalArgumentException();
        }

        return menuCount;
    }

    private int validateAndConvertDateInputToOrderDate(String dateInput) {
        int orderDate;
        try {
            orderDate = Integer.parseInt(dateInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (orderDate < 1 || 31 < orderDate) {
            throw new IllegalArgumentException();
        }

        return orderDate;
    }
}
