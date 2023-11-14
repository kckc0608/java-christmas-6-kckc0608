package christmas;

public class Menu {
    public enum Type { APPETIZER, MAIN, DESERT, DRINK }
    private String name;
    private int price;
    private Type type;

    public Menu(String name, int price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
