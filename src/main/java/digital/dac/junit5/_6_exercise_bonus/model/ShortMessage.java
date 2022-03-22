package digital.dac.junit5._6_exercise_bonus.model;

public class ShortMessage {

    private final String text;

    public ShortMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "ShortMessage{" +
                "text='" + text + '\'' +
                '}';
    }
}
