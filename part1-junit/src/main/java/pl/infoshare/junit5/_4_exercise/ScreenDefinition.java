package pl.infoshare.junit5._4_exercise;

import java.time.LocalDate;
import java.util.List;

public class ScreenDefinition {

    private final String title;
    private final List<SeriesTile> seriesTiles;
    private final LocalDate availableAtDay;

    public ScreenDefinition(String title, List<SeriesTile> seriesTiles, LocalDate availableAtDay) {
        this.title = title;
        this.seriesTiles = seriesTiles;
        this.availableAtDay = availableAtDay;
    }

    public String getTitle() {
        return title;
    }

    public List<SeriesTile> getSeriesTiles() {
        return seriesTiles;
    }

    public LocalDate getAvailableAtDay() {
        return availableAtDay;
    }
}
