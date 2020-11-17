package pl.infoshare.junit5._6_exercise_bonus.sentence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SentenceValidatorTest {

    private final SentenceValidator testObj = new SentenceValidator();

    @Test
    void should_return_true_when_sentence_is_correct() {
        // given
        var givenSentence = "Correct sentence.";

        // when
        var result = testObj.isValidSentence(givenSentence);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void should_return_false_when_sentence_does_not_ends_with_dot() {
        // given
        var givenSentence = "Incorrect sentence";

        // when
        var result = testObj.isValidSentence(givenSentence);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void should_return_false_when_sentence_does_not_start_with_uppercase_letter() {
        // given
        var givenSentence = "incorrect sentence.";

        // when
        var result = testObj.isValidSentence(givenSentence);

        // then
        assertThat(result).isFalse();
    }
}