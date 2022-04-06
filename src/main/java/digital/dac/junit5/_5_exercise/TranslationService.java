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

    public TranslatedWord translate(String word, Locale locale, String fallback) {
        try {
            var translation = translationProvider.getTranslation(word, locale);
            return new TranslatedWord(word, translation);
        } catch (TranslationNotFoundException ex) {
            return new TranslatedWord(word, fallback);
        }
    }
}
