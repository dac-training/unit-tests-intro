package pl.infoshare.junit5._4_exercise;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class DayOfWeekService {

    public DayOfWeek getDayOfWeekFromDate(LocalDate date) {
        return date.getDayOfWeek();
    }
}
