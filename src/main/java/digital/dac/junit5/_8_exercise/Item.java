package digital.dac.junit5._8_exercise;

import java.math.BigDecimal;

public class Item {

    private final String name;
    private final BigDecimal price;

    public Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
