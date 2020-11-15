package pl.infoshare.junit5._8_exercise;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Order {

    private final Integer id;
    private final BigDecimal originalPrice;
    private final BigDecimal discount;

    public Order(Integer id, BigDecimal originalPrice, BigDecimal discount) {
        this.id = id;
        this.originalPrice = originalPrice;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getFinalPrice() {
        return originalPrice.multiply(discount.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
    }
}
