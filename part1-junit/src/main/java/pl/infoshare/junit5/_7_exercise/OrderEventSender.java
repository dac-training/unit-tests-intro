package pl.infoshare.junit5._7_exercise;

public interface OrderEventSender {

    void sendEvent(Integer id, OrderEventType eventType);

}
