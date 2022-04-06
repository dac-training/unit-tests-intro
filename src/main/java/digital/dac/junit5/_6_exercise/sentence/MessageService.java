package digital.dac.junit5._6_exercise.sentence;

import digital.dac.junit5._6_exercise.model.ShortMessage;
import digital.dac.junit5._6_exercise.model.MessageSaveException;
import digital.dac.junit5._6_exercise.sentence.repository.MessageRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MessageService {

    private final SentenceCensor sentenceCensor;
    private final MessageRepository messageRepository;

    public MessageService(SentenceCensor sentenceCensor, MessageRepository messageRepository) {
        this.sentenceCensor = sentenceCensor;
        this.messageRepository = messageRepository;
    }

    public void saveShortMessage(List<String> sentences) {
        String censoredMessage = sentences.stream()
                .map(sentenceCensor::censor)
                .collect(Collectors.joining(" "));

        try {
            var shortMessage = new ShortMessage(censoredMessage);
            messageRepository.save(shortMessage);
        } catch (MessageSaveException e) {
            throw new IllegalStateException("Something went wrong!");
        }
    }
}
