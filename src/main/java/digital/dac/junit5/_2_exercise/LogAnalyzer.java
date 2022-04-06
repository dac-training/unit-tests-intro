package digital.dac.junit5._2_exercise;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;

/**
 * Ćwiczenie 3. Napisz testy dla poniższej klasy. Do asercji wykorzystaj bibliotekę AssertJ.
 */
public class LogAnalyzer {

    private static final List<Log> logs = List.of(
            new Log("First prod log", "prod", LocalDate.of(2020, Month.AUGUST, 25)),
            new Log("Second prod log", "prod", LocalDate.of(2020, Month.JANUARY, 20)),
            new Log("First dev log", "dev", LocalDate.of(2020, Month.OCTOBER, 10)),
            new Log("Second dev log", "dev", LocalDate.of(2020, Month.SEPTEMBER, 15)),
            new Log("Third dev log", "dev", LocalDate.of(2020, Month.MARCH, 5))
    );

    public List<Log> findAllByEnv(String environment) {
        return logs.stream()
                .filter(l -> l.getEnvironment().equals(environment))
                .collect(Collectors.toList());
    }

    public Optional<Log> findFirstLogFromDate(LocalDate date) {
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalStateException("Date cannot be from the future");
        }

        return logs.stream()
                .filter(c -> c.getLogDate().equals(date))
                .findFirst();
    }

    public BigDecimal getAverageLogsPerDay() {
        var maxDate = logs.stream().map(Log::getLogDate).max(comparing(identity())).orElse(LocalDate.now());
        var minDate = logs.stream().map(Log::getLogDate).min(comparing(identity())).orElse(LocalDate.now());

        var hoursBetween = ChronoUnit.DAYS.between(minDate, maxDate);

        return BigDecimal.valueOf(logs.size()).divide(BigDecimal.valueOf(hoursBetween), 6, RoundingMode.HALF_UP);
    }
}
