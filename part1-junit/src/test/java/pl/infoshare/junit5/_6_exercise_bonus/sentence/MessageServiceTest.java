package pl.infoshare.junit5._6_exercise_bonus.sentence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.infoshare.junit5._6_exercise_bonus.model.MessageSaveException;
import pl.infoshare.junit5._6_exercise_bonus.model.ShortMessage;
import pl.infoshare.junit5._6_exercise_bonus.sentence.repository.MessageRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @InjectMocks
    private MessageService testObj;
    @Mock
    private SentenceCensor sentenceCensor;
    @Mock
    private MessageRepository messageRepository;
    @Captor
    private ArgumentCaptor<ShortMessage> shortMessageCaptor;

    @Test
    void should_save_message() throws MessageSaveException {
        // given
        var givenFirstSentence = "First sentence.";
        var givenSecondSentence = "Second sentence.";

        var givenSentences = List.of(givenFirstSentence, givenSecondSentence);
        var expectedMessage = new ShortMessage("First ***. Second sentence.");

        when(sentenceCensor.censor(givenFirstSentence)).thenReturn("First ***.");
        when(sentenceCensor.censor(givenSecondSentence)).thenReturn(givenSecondSentence);

        // when
        testObj.saveShortMessage(givenSentences);

        // then
        verify(messageRepository).save(shortMessageCaptor.capture());
        var result = shortMessageCaptor.getValue();

        assertThat(result.getText()).isEqualTo("First ***. Second sentence.");
    }

    @Test
    void should_handle_exception() {
        // given

        // when

        // then
    }
}