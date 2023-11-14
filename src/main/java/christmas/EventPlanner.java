package christmas;

import christmas.views.InputView;
import christmas.views.OutputView;

public class EventPlanner {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public EventPlanner() {
        outputView.printWelcome();
        inputView.readDate();
    }
}
