package pl.infoshare.junit5._3_exercise;

import java.time.LocalDate;

public class Log {

    private final String message;
    private final String environment;
    private final LocalDate logDate;

    public Log(String message, String environment, LocalDate logDate) {
        this.message = message;
        this.environment = environment;
        this.logDate = logDate;
    }

    public String getMessage() {
        return message;
    }

    public String getEnvironment() {
        return environment;
    }

    public LocalDate getLogDate() {
        return logDate;
    }
}
