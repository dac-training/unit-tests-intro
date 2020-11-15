package pl.infoshare.junit5._18_summary.model;

public class IncorrectSentenceException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Sentence '%s' is incorrect.";

    public IncorrectSentenceException(String sentence) {
        super(String.format(ERROR_MESSAGE, sentence));
    }
}
