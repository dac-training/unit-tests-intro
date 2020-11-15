package pl.infoshare.junit5._18_summary.sentence;

import pl.infoshare.junit5._18_summary.model.MessageSaveException;
import pl.infoshare.junit5._18_summary.model.ShortMessage;

public interface MessageRepository {

    void save(ShortMessage shortMessage) throws MessageSaveException;

}
