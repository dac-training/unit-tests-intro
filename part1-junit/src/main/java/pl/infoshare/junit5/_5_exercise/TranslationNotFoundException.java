package pl.infoshare.junit5._5_exercise;

public class TranslationNotFoundException extends RuntimeException {

    public TranslationNotFoundException() {
        super("Translation was not found");
    }
}
