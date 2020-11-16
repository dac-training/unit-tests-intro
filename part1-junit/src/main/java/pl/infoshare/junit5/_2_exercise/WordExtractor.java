package pl.infoshare.junit5._2_exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Ćwiczenie 2. Napisz testy dla poniższej klasy.
 * Dodatkowo upewnij się, że wykonanie medoty extractNextThreeWords nie zajmuje więcej czasu niż jedna sekunda
 */
public class WordExtractor {

    public boolean containsWord(String sentence, String word) {
        return sentence.toLowerCase().contains(word.toLowerCase());
    }

    public String extractSentenceOrThrow(String text, String word) {
        return extractSentenceWithWord(text, word)
                .orElseThrow(() -> new SentenceNotFoundException(word));
    }

    public Optional<String> extractSentenceWithWord(String text, String word) {
        return Arrays.stream(text.split("\\."))
                .filter(sentence -> containsWord(sentence, word))
                .findFirst();
    }

    public List<String> extractNextThreeWords(String text, String word) {
        var allWords = Arrays.asList(text.split(" "));
        var wordIndex = allWords.indexOf(word);

        return allWords.subList(wordIndex, wordIndex + 3);
    }
}
