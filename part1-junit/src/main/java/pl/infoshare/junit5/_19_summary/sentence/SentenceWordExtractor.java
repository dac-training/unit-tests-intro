package pl.infoshare.junit5._19_summary.sentence;

import pl.infoshare.junit5._19_summary.model.ExtractedWord;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class SentenceWordExtractor {

    private static final int MIN_WORD_LENGTH = 3;

    public Optional<ExtractedWord> extractLongestWord(String sentence) {
        return extractAllWords(sentence)
                .stream()
                .filter(not(s -> s.getValue().contains("*")))
                .findFirst();
    }

    public List<ExtractedWord> extractAllWords(String sentence) {
        return Arrays.stream(removePunctuation(sentence).split(" "))
                .filter(word -> word.length() > MIN_WORD_LENGTH)
                .map(ExtractedWord::new)
                .collect(Collectors.toList());
    }

    private String removePunctuation(String sentence) {
        return sentence.replaceAll("[?,.:;!]", "");
    }
}
