package pl.infoshare.junit5._18_summary.sentence;

import pl.infoshare.junit5._18_summary.model.IncorrectSentenceException;

public class SentenceValidator {

    public void validateWithException(String sentence) {
        if (!isValidSentence(sentence)) {
            throw new IncorrectSentenceException(sentence);
        }
    }

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
