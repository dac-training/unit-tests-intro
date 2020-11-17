package pl.infoshare.junit5._4_exercise_bonus.model;

public class MailContact {

    private final Integer id;
    private final String name;
    private final String address;

    public MailContact(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public MailContact withId(Integer id) {
        return new MailContact(id, name, address);
    }
}
