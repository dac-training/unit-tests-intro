package pl.infoshare.junit5._6_exercise_bonus.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortMessage that = (ShortMessage) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
