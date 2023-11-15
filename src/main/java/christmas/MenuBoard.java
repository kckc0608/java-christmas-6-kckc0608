package christmas;

import java.util.HashMap;

public class MenuBoard {
    private HashMap<String, Menu> menuBoard;

    public Menu getMenuByName(String name) {
        return menuBoard.get(name);
    }

    public void addNewMenu(String name, Menu menu) {
        menuBoard.put(name, menu);
    }
}
