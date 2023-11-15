package christmas;

import java.util.HashMap;

public class MenuBoard {
    private static HashMap<String, Menu> menuBoard;

    public static Menu getMenuByName(String name) {
        return menuBoard.get(name);
    }

    public static void addNewMenu(String name, Menu menu) {
        menuBoard.put(name, menu);
    }
}
