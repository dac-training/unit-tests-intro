package digital.dac.junit5._2_exercise;

public class SentenceNotFoundException extends RuntimeException {

    public SentenceNotFoundException(String word) {
        super(String.format("There is no sentence with word '%s' inside.", word));
    }
}
