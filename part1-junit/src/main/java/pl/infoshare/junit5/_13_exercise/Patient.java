package pl.infoshare.junit5._13_exercise;

public class Patient {

    private final Integer id;
    private final String name;
    private final String description;

    public Patient(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static Patient fromString(String lane) {
        var parts = lane.split("\\|");

        return new Patient(
                Integer.valueOf(parts[0]),
                parts[1],
                parts[2]
        );
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String asString() {
        return String.format("%s|%s|%s", id, name, description);
    }

}
