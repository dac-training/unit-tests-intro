package digital.dac.junit5._4_exercise;

public class TranslationNotFoundException extends RuntimeException {

    public TranslationNotFoundException() {
        super("Translation was not found");
    }
}
