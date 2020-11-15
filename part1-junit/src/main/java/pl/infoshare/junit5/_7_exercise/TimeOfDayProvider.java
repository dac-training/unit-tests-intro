package pl.infoshare.junit5._7_exercise;

import java.time.LocalDateTime;

public class TimeOfDayProvider {

    public TimeOfDay getTimeOfDay() {
        var time = LocalDateTime.now();

        if (time.getHour() < 6) {
            return TimeOfDay.NIGHT;
        }
        if (time.getHour() < 12) {
            return TimeOfDay.MORNING;
        }
        if (time.getHour() < 18) {
            return TimeOfDay.AFTERNOON;
        }

        return TimeOfDay.EVENING;
    }

}
