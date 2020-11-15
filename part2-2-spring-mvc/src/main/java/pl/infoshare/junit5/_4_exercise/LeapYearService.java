package pl.infoshare.junit5._4_exercise;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LeapYearService {

    public boolean isDateInLeapYear(LocalDate date) {
        return date.isLeapYear();
    }

}
