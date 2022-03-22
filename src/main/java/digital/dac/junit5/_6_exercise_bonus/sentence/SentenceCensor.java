package digital.dac.junit5._6_exercise_bonus.sentence;

import digital.dac.junit5._6_exercise_bonus.model.IncorrectSentenceException;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class SentenceCensor {

    private static final List<String> wordsToCensor = List.of("gra", "wizja");

    private final SentenceValidator sentenceValidator;

    public SentenceCensor(SentenceValidator sentenceValidator) {
        this.sentenceValidator = sentenceValidator;
    }

    public String censor(String sentence) {
        if (!sentenceValidator.isValidSentence(sentence)) {
            throw new IncorrectSentenceException(sentence);
        }

        return wordsToCensor.stream().reduce(sentence, this::censorSentence);
    }

    private String censorSentence(String sentence, String word) {
        var censoredWord = censorWord(word);
        return sentence.replace(word, censoredWord);
    }

    private String censorWord(String word) {
        return Arrays.stream(word.split(""))
                .map(c -> "*")
                .collect(joining());
    }
}
