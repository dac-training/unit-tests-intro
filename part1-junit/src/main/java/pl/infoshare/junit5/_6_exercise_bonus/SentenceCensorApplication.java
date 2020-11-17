package pl.infoshare.junit5._6_exercise_bonus;


import pl.infoshare.junit5._6_exercise_bonus.sentence.MessageService;
import pl.infoshare.junit5._6_exercise_bonus.sentence.SentenceCensor;
import pl.infoshare.junit5._6_exercise_bonus.sentence.SentenceValidator;
import pl.infoshare.junit5._6_exercise_bonus.sentence.repository.NoOpMessageRepository;

import java.util.List;

/**
 * Exercise 6b. Napisz testy dla klas SentenceValidator, SentenceCensor oraz MessageService. Możesz wykorzystać poniższy kod, aby sprawdzić
 * w jaki sposób aplikacja działa.
 */
public class SentenceCensorApplication {

    public static void main(String[] args) {
        var sentences = List.of(
                "First sentence without any words to censor.",
                "Second sentence with single word to censor: gra.",
                "Kolejne zdanie gdzie slowo wizja oraz slowo gra podlegaja cenzurze."
        );

        var sentenceValidator = new SentenceValidator();
        var sentenceCensor = new SentenceCensor(sentenceValidator);
        var messageRepository = new NoOpMessageRepository();

        var messageService = new MessageService(sentenceCensor, messageRepository);

        messageService.saveShortMessage(sentences);
    }

}