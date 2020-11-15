package pl.infoshare.junit5._4_exercise;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

/**
 * Ćwiczenie 4. Napisz testy dla poniższej klasy. Spróbuj wykorzystać rozszerzenie SoftlyAssertions.
 */
public class ScreenDefinitionProvider {

    private final List<ScreenDefinition> screenDefinitions = List.of(
            new ScreenDefinition("Romantic", List.of(
                    new SeriesTile("365 Days", false),
                    new SeriesTile("A rainy day in New York", false)
            ), LocalDate.of(2021, Month.FEBRUARY, 14)),
            new ScreenDefinition("Thriller", List.of(
                    new SeriesTile("In the shadow of the moon", true),
                    new SeriesTile("Fantasy island", true),
                    new SeriesTile("The invisible man", true)
            ), LocalDate.of(2021, Month.OCTOBER, 28))
    );

    public Optional<ScreenDefinition> getScreenDefinitionFor(LocalDate date) {
        return screenDefinitions.stream()
                .filter(d -> d.getAvailableAtDay().isEqual(date))
                .findFirst();
    }
}
