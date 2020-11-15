package pl.infoshare.junit5._9_exercise;

import java.util.List;

/**
 * Ćwiczenie 8. Napisz test parametryzowany, który sprawdzi zachowanie klasy dla różnych wyrazów
 */
public class WordCensor {

    private final List<String> wordsToCensor;

    public WordCensor(List<String> wordsToCensor) {
        this.wordsToCensor = wordsToCensor;
    }

    public String censorWord(String word) {
        if (wordsToCensor.contains(word)) {
            return word.replaceAll(".", "*");
        }

        return word;
    }
}
