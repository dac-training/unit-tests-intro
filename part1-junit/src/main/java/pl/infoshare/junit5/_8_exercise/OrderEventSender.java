package pl.infoshare.junit5._8_exercise;

public interface OrderEventSender {

    void sendEvent(Integer id, OrderEventType eventType);

}
