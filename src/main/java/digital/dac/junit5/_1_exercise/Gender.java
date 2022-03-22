package digital.dac.junit5._1_exercise;

public enum Gender {
    MALE("mr."),
    FEMALE("mrs."),
    EXAMPLE("ex");

    private final String prefix;

    Gender(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
