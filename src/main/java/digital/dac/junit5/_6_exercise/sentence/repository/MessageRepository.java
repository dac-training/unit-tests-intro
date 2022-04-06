package digital.dac.junit5._6_exercise.sentence.repository;

import digital.dac.junit5._6_exercise.model.MessageSaveException;
import digital.dac.junit5._6_exercise.model.ShortMessage;

public interface MessageRepository {

    void save(ShortMessage shortMessage) throws MessageSaveException;

}
