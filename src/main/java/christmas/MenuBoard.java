package christmas;

import java.util.HashMap;

public class MenuBoard {
    private static final HashMap<String, Menu> menuBoard = new HashMap<>();

    public static Menu getMenuByName(String name) {
        Menu menu  = menuBoard.get(name);
        if (menu == null) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        return menu;
    }

    public static void addNewMenu(String name, Menu menu) {
        menuBoard.put(name, menu);
    }

    public static void clearBoard() {
        menuBoard.clear();
    }
}
