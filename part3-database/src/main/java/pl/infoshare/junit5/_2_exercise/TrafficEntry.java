package pl.infoshare.junit5._2_exercise;

import java.math.BigDecimal;
import java.time.Instant;

public class TrafficEntry {

    private final Instant instant;
    private final BigDecimal speed;

    public TrafficEntry(Instant instant, BigDecimal speed) {
        this.instant = instant;
        this.speed = speed;
    }

    public Instant getInstant() {
        return instant;
    }

    public BigDecimal getSpeed() {
        return speed;
    }
}
