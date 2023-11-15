package christmas;

import christmas.views.InputView;
import christmas.views.OutputView;

public class EventPlanner {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public EventPlanner() {
        initPlanner();
        outputView.printWelcome();
        int date = inputView.readDate();
        Order order = inputView.readOrder();
        outputView.printBenefitsInfo();
        outputView.printOrder(order);
    }

    private void initPlanner() {
        MenuBoard.clearBoard();

        MenuBoard.addNewMenu("양송이수프", new Menu("양송이수프", 6000, Menu.Type.APPETIZER));
        MenuBoard.addNewMenu("타파스", new Menu("타파스", 5500, Menu.Type.APPETIZER));
        MenuBoard.addNewMenu("시저샐러드", new Menu("시저샐러드", 8000, Menu.Type.APPETIZER));

        MenuBoard.addNewMenu("티본스테이크", new Menu("티본스테이크", 55000, Menu.Type.MAIN));
        MenuBoard.addNewMenu("바비큐립", new Menu("바비큐립", 54000, Menu.Type.MAIN));
        MenuBoard.addNewMenu("해산물파스타", new Menu("해산물파스타", 35000, Menu.Type.MAIN));
        MenuBoard.addNewMenu("크리스마스파스타", new Menu("크리스마스파스타", 25000, Menu.Type.MAIN));

        MenuBoard.addNewMenu("초코케이크", new Menu("초코케이크", 15000, Menu.Type.DESERT));
        MenuBoard.addNewMenu("아이스크림", new Menu("아이스크림", 5000, Menu.Type.DESERT));

        MenuBoard.addNewMenu("제로콜라", new Menu("제로콜라", 3000, Menu.Type.DRINK));
        MenuBoard.addNewMenu("레드와인", new Menu("레드와인", 60000, Menu.Type.DRINK));
        MenuBoard.addNewMenu("샴페인", new Menu("샴페인", 25000, Menu.Type.DRINK));
    }
}
