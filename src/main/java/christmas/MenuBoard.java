package christmas;

import java.util.HashMap;

public class MenuBoard {
    private static final HashMap<String, Menu> menuBoard = new HashMap<>();

    public static Menu getMenuByName(String name) {
        Menu menu  = menuBoard.get(name);
        if (menu == null) {
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
