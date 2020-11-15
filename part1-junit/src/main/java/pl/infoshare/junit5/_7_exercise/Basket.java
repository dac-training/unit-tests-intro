package pl.infoshare.junit5._7_exercise;

import java.util.List;

public class Basket {

    private final List<Item> items;

    public Basket(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
