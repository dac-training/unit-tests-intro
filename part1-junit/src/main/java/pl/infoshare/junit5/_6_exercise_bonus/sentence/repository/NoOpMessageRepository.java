package pl.infoshare.junit5._6_exercise_bonus.sentence.repository;

import pl.infoshare.junit5._6_exercise_bonus.model.MessageSaveException;
import pl.infoshare.junit5._6_exercise_bonus.model.ShortMessage;

public class NoOpMessageRepository implements MessageRepository {
    @Override
    public void save(ShortMessage shortMessage) throws MessageSaveException {

    }
}
