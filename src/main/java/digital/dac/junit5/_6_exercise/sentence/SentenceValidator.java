package digital.dac.junit5._6_exercise.sentence;

public class SentenceValidator {

    public boolean isValidSentence(String sentence) {
        return endsWithDot(sentence) && startsWithCapitalLetter(sentence);
    }

    private boolean endsWithDot(String sentence) {
        return sentence.endsWith(".");
    }

    private boolean startsWithCapitalLetter(String sentence) {
        return Character.isUpperCase(sentence.charAt(0));
    }
}
