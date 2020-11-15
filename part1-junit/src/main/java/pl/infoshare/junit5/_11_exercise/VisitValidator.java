package pl.infoshare.junit5._11_exercise;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Ćwiczenie 10. Napisz test parametryzowany, który sprawdzi zachowanie klasy dla różnych wartości.
 */
public class VisitValidator {

    boolean canScheduleVisit(Visitor visitor, LocalDate date) {
        if (visitor.getAge() > 60) {
            return date.getDayOfWeek().equals(DayOfWeek.MONDAY)
                    || date.getDayOfWeek().equals(DayOfWeek.WEDNESDAY);
        }

        return date.getDayOfWeek().equals(DayOfWeek.TUESDAY)
                || date.getDayOfWeek().equals(DayOfWeek.THURSDAY)
                || date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
    }

}
