package pl.infoshare.junit5._9_exercise;

import java.math.BigDecimal;

/**
 * Ćwiczenie 9. Napisz test parametryzowany, który wczyta plik incomes.csv i na jego podstawie dostarczy wartości do testów.
 * TIP: Istnieje specjalna adnotacja, która może ułatwić Ci to zadanie.
 */
public class IncomeCalculator {

    public BigDecimal calculateIncome(BigDecimal salary, BigDecimal costs, Integer taxThreshold) {
        return salary.subtract(costs).multiply(BigDecimal.valueOf((100 - taxThreshold) / 100.0));
    }
}
