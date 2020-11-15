package pl.infoshare.junit5._19_summary.sentence;

import pl.infoshare.junit5._19_summary.model.MessageSaveException;
import pl.infoshare.junit5._19_summary.model.ShortMessage;

public interface MessageRepository {

    void save(ShortMessage shortMessage) throws MessageSaveException;

}
