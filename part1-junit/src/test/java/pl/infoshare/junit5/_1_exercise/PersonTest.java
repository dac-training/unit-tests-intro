package pl.infoshare.junit5._1_exercise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @ParameterizedTest
    @EnumSource(Gender.class)
    void name(Gender givenGender) {
        // given
        var givenPerson = new Person("name", "surname", 20, givenGender);

        // when
        var result = givenPerson.getFullName();

        // then
        assertThat(result)
                .isNotEmpty()
                .startsWith(givenGender.getPrefix())
                .endsWith("name surname");
        ;
    }
}