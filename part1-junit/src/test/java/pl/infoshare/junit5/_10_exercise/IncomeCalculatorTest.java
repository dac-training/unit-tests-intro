package pl.infoshare.junit5._10_exercise;

import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class IncomeCalculatorTest {

    private IncomeCalculator testObj = new IncomeCalculator();

    @ParameterizedTest
    @CsvFileSource(resources = "incomes.csv", numLinesToSkip = 1, delimiterString = ",")
    void name(BigDecimal givenSalary, BigDecimal givenCosts, int givenTax, BigDecimal expectedResult) {
        // when
        var result = testObj.calculateIncome(givenSalary, givenCosts, givenTax);

        // then
        assertThat(result).isCloseTo(expectedResult, Offset.offset(BigDecimal.valueOf(0.02)));
    }
}