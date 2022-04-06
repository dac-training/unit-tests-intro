package digital.dac.junit5._6_exercise.model;

public class IncorrectSentenceException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Sentence '%s' is incorrect.";

    public IncorrectSentenceException(String sentence) {
        super(String.format(ERROR_MESSAGE, sentence));
    }
}
