package christmas;

import christmas.EventPlanner.EventType;

public class Event {
    private int applyAmount;
    private EventType eventType;

    public Event(EventType eventType, int applyAmount) {
        this.eventType = eventType;
        this.applyAmount = applyAmount;
    }

    public EventType getEventType() {
        return eventType;
    }

    public int getApplyAmount() {
        return applyAmount;
    }
}
