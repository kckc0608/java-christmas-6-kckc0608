package christmas.views;

public class OutputView {
    private final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    public void printWelcome() {
        System.out.println(WELCOME_MESSAGE);
    }
    public void printMenu() {
        System.out.println("<주문 메뉴>");
        // ...
    }
    // ...
}
