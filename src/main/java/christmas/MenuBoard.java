package christmas;

import java.util.HashMap;

public class MenuBoard {
    private static HashMap<String, Menu> menuBoard;

    public static Menu getMenuByName(String name) {
        Menu menu  = menuBoard.get(name);
        if (menu == null) {
            // TODO : Print Error Message
            throw new IllegalArgumentException();
        }
        return menu;
    }

    public static void addNewMenu(String name, Menu menu) {
        menuBoard.put(name, menu);
    }
}
