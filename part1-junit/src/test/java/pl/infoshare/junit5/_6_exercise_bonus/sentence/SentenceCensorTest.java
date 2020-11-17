package pl.infoshare.junit5._6_exercise_bonus.sentence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.infoshare.junit5._6_exercise_bonus.model.IncorrectSentenceException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SentenceCensorTest {

    @InjectMocks
    private SentenceCensor testObj;
    @Mock
    private SentenceValidator sentenceValidator;

    @Test
    void should_leave_sentence_untouched_when_no_words_to_be_censored() {
        // given
        var givenSentence = "Sentence without words.";
        when(sentenceValidator.isValidSentence(givenSentence)).thenReturn(true);

        // when
        var result = testObj.censor(givenSentence);

        // then
        assertThat(result).isEqualTo("Sentence without words.");
    }

    @Test
    void should_censor_single_word() {
        // given
        var givenSentence = "Sentence with word gra.";
        when(sentenceValidator.isValidSentence(givenSentence)).thenReturn(true);

        // when
        var result = testObj.censor(givenSentence);

        // then
        assertThat(result).isEqualTo("Sentence with word ***.");
    }

    @Test
    void should_censor_multiple_words() {
        // given
        var givenSentence = "Sentence with word gra wizja.";
        when(sentenceValidator.isValidSentence(givenSentence)).thenReturn(true);

        // when
        var result = testObj.censor(givenSentence);

        // then
        assertThat(result).isEqualTo("Sentence with word *** *****.");
    }

    @Test
    void should_throw_exception_when_sentence_is_not_correct() {
        // given
        var givenSentence = "Does not matter";
        when(sentenceValidator.isValidSentence(givenSentence)).thenReturn(false);

        // when
        assertThatThrownBy(() -> testObj.censor(givenSentence))
                .isInstanceOf(IncorrectSentenceException.class);
    }
}