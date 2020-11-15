package pl.infoshare.junit5._2_exercise;

import org.springframework.stereotype.Component;

@Component
public class TranslationRepository {

    public boolean existsByValueAndLanguage(String value, String language) {
        throw new IllegalStateException("Not implemented!");
    }

    public void save(Translation translation) {
        throw new IllegalStateException("Not implemented!");
    }
}
