package pl.infoshare.junit5._11_exercise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class VisitValidatorTest {

    private final VisitValidator testObj = new VisitValidator();

    @ParameterizedTest
    @MethodSource("getData")
    void should_schedule_visit(Visitor givenVisitor, LocalDate givenDate, boolean expected) {
        // when
        var result = testObj.canScheduleVisit(givenVisitor, givenDate);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> getData() {
        var november = LocalDate.of(2020, Month.NOVEMBER, 1);
        var olderVisitor = new Visitor("Old", 61);
        var youngerVisitor = new Visitor("Young", 59);

        return Stream.of(
                Arguments.of(olderVisitor, november.withDayOfMonth(2), true),
                Arguments.of(olderVisitor, november.withDayOfMonth(3), false),
                Arguments.of(olderVisitor, november.withDayOfMonth(4), true),
                Arguments.of(olderVisitor, november.withDayOfMonth(5), false),
                Arguments.of(olderVisitor, november.withDayOfMonth(6), false),
                Arguments.of(olderVisitor, november.withDayOfMonth(7), false),
                Arguments.of(olderVisitor, november.withDayOfMonth(8), false),
                Arguments.of(youngerVisitor, november.withDayOfMonth(2), false),
                Arguments.of(youngerVisitor, november.withDayOfMonth(3), true),
                Arguments.of(youngerVisitor, november.withDayOfMonth(4), false),
                Arguments.of(youngerVisitor, november.withDayOfMonth(5), true),
                Arguments.of(youngerVisitor, november.withDayOfMonth(6), true),
                Arguments.of(youngerVisitor, november.withDayOfMonth(7), false),
                Arguments.of(youngerVisitor, november.withDayOfMonth(8), false)
        );
    }


}