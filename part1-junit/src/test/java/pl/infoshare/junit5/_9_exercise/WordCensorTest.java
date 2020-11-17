package pl.infoshare.junit5._9_exercise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WordCensorTest {

    private final WordCensor testObj = new WordCensor();

    @ParameterizedTest
    @ValueSource(strings = {"desk", "trap", "television", "light", "one"})
    void name(String givenWord) {
        // when
        var result = testObj.censorWord(givenWord);

        // then
        assertThat(result)
                .contains("*")
                .hasSize(givenWord.length());
    }
}