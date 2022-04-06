package digital.dac.junit5._3_exercise;

public class SeriesTile {

    private final String title;
    private final boolean isAdult;

    public SeriesTile(String title, boolean isAdult) {
        this.title = title;
        this.isAdult = isAdult;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAdult() {
        return isAdult;
    }
}
