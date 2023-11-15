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
        String input = Console.readLine();
        // validate(input);
        return Integer.parseInt(input);
    }

    public Order readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        Map<Menu, Integer> orderMap = validateAndConvertInputToOrderMap(input);
        return new Order(orderMap);
    }

    private Map<Menu,Integer> validateAndConvertInputToOrderMap(String orderInput) {
        List<String> menuOrders = Arrays.stream(orderInput.split(",")).toList();

        HashMap<Menu, Integer> orderMap = new HashMap<>();
        for (String menuOrder : menuOrders) {
            List<String> order =  Arrays.stream(menuOrder.split("-")).toList();
            String menuName = order.get(0);
            int menuCount;
            try {
                menuCount = Integer.parseInt(order.get(1));
            } catch (NumberFormatException ex) {
                // TODO : Print Error Message
                throw new IllegalArgumentException();
            }

            Menu menu = MenuBoard.getMenuByName(menuName);

            orderMap.put(menu, menuCount);
        }
        return orderMap;
    }
}
