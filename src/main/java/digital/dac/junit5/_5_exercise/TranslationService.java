package digital.dac.junit5._5_exercise;

import java.util.Locale;

/**
 * Ćwiczenie 5. Napisz testy dla poniższej klasy wykorzystując bibliotekę Mockito.
 */
public class TranslationService {

    private final TranslationProvider translationProvider;

    public TranslationService(TranslationProvider translationProvider) {
        this.translationProvider = translationProvider;
    }

    public String translate(String word, Locale locale, String fallback) {
        try {
            return translationProvider.getTranslation(word, locale);
        } catch (TranslationNotFoundException ex) {
            return fallback;
        }
    }
}
