package pl.infoshare.junit5._12_exercise;

import java.math.BigDecimal;


/**
 * Ćwiczenie 11. Napisz 'Nested' test który sprawdzi dla różnych wartości czy dane Claim jest eligible
 */
public class Claim {

    private Delay delay;
    private BigDecimal distance;
    private Regulation regulation;

    public Delay getDelay() {
        return delay;
    }

    public void setDelay(Delay delay) {
        this.delay = delay;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Regulation getRegulation() {
        return regulation;
    }

    public void setRegulation(Regulation regulation) {
        this.regulation = regulation;
    }

    public boolean isEligible() {
        if (delay == Delay.ABOVE_4_HOURS) {
            return BigDecimal.valueOf(regulation.getMinDistance()).compareTo(distance) < 0;
        }

        return false;
    }

}
