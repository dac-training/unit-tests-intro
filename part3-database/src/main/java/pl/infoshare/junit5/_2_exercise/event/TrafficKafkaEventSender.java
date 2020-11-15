package pl.infoshare.junit5._2_exercise.event;

import org.springframework.stereotype.Component;

@Component
class TrafficKafkaEventSender implements TrafficEventSender {

    @Override
    public void sendEvent(TrafficEventType trafficEventType) {
        System.out.println("Sending event " + trafficEventType);
    }
}
