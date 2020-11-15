package pl.infoshare.junit5._19_summary.sentence;

import pl.infoshare.junit5._19_summary.model.MessageSaveException;
import pl.infoshare.junit5._19_summary.model.ShortMessage;
import pl.infoshare.junit5._19_summary.model.Tag;

import java.util.List;
import java.util.stream.Collectors;

public class MessageService {

    private final SentenceCensor sentenceCensor;
    private final MessageRepository messageRepository;
    private final SentenceWordExtractor sentenceWordExtractor;

    public MessageService(SentenceCensor sentenceCensor, MessageRepository messageRepository, SentenceWordExtractor sentenceWordExtractor) {
        this.sentenceCensor = sentenceCensor;
        this.messageRepository = messageRepository;
        this.sentenceWordExtractor = sentenceWordExtractor;
    }

    public void saveShortMessage(List<String> sentences) {
        var censoredMessage = sentences.stream()
                .map(sentenceCensor::censor)
                .collect(Collectors.joining());

        var tags = sentenceWordExtractor.extractLongestWord(censoredMessage)
                .map(Tag::new)
                .map(List::of)
                .orElse(List.of());

        try {
            var shortMessage = new ShortMessage(censoredMessage, tags);
            messageRepository.save(shortMessage);
        } catch (MessageSaveException e) {
            throw new IllegalStateException("Something went wrong!");
        }
    }
}
