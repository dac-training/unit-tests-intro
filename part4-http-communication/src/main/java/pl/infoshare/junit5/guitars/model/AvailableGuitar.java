package pl.infoshare.junit5.guitars.model;


public class AvailableGuitar {

    private final String id;
    private final String name;
    private final Integer price;

    public AvailableGuitar(String id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
