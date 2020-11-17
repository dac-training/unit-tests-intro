package pl.infoshare.junit5._1_exercise;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

/**
 * Napisz test integracyjny, który sprawdzi poprawność konwersji z metra na kilometr
 * Part II: Napisz test parametryzowany, który sprawdzi poprawność konwersji dla wszystkich wspieranych jednostek
 */
@Component
public class MeasureUnitService {

    private final MeasureUnitProperties measureUnitProperties;

    public MeasureUnitService(MeasureUnitProperties measureUnitProperties) {
        this.measureUnitProperties = measureUnitProperties;
    }

    @PostConstruct
    void init() {
        System.out.println();
    }

    public BigDecimal convertUnit(BigDecimal value, String desiredUnit) {
        var factor = measureUnitProperties.getUnitFor(desiredUnit);
        return value.multiply(factor);
    }
}
