package christmas;

public class Menu {
    public enum Type { APPETIZER, MAIN, DESERT, DRINK }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }

    private String name;
    private int price;
    private Type type;

    public Menu(String name, int price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
