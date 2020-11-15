package pl.infoshare.junit5._18_summary.model;

public class ExtractedWord {

    private final String value;
    private final Integer numberOfLetters;

    public ExtractedWord(String value) {
        this.value = value;
        this.numberOfLetters = value.length();
    }

    public String getValue() {
        return value;
    }

}
