package pl.infoshare.junit5._2_exercise;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5._2_exercise.event.TrafficEventSender;
import pl.infoshare.junit5._2_exercise.event.TrafficEventType;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class TrafficReportService {

    private final TrafficEventSender trafficEventSender;

    public TrafficReportService(TrafficEventSender trafficEventSender) {
        this.trafficEventSender = trafficEventSender;
    }

    public void report(List<TrafficEntry> trafficEntries) {
        trafficEntries.sort(Comparator.comparing(TrafficEntry::getInstant));
        trafficEventSender.sendEvent(TrafficEventType.START_REPORT);
        IntStream.range(0, trafficEntries.size() - 1)
                .mapToObj(index -> mapToEvent(trafficEntries.get(index), trafficEntries.get(index + 1)))
                .forEach(trafficEventSender::sendEvent);
        trafficEventSender.sendEvent(TrafficEventType.FINISH_REPORT);
    }

    private TrafficEventType mapToEvent(TrafficEntry previous, TrafficEntry current) {
        if (current.getSpeed().compareTo(previous.getSpeed()) == 0) {
            return TrafficEventType.NO_CHANGES;
        }
        if (current.getSpeed().compareTo(BigDecimal.ZERO) == 0) {
            return TrafficEventType.STOPPED;
        }
        if (current.getSpeed().compareTo(previous.getSpeed()) > 0) {
            return TrafficEventType.ACCELERATING;
        }
        return TrafficEventType.SLOWING_DOWN;
    }


}
