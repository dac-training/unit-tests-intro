package digital.dac.junit5._5_exercise;

public class TranslatedWord {

    private final String original;
    private final String translation;

    public TranslatedWord(String original, String translation) {
        this.original = original;
        this.translation = translation;
    }

    public String getOriginal() {
        return original;
    }

    public String getTranslation() {
        return translation;
    }
}
