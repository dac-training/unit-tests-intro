package pl.infoshare.junit5._19_summary.model;

import java.util.List;
import java.util.Objects;

public class ShortMessage {

    private final String text;
    private final List<Tag> tags;

    public ShortMessage(String text, List<Tag> tags) {
        this.text = text;
        this.tags = tags;
    }

    public String getText() {
        return text;
    }

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortMessage that = (ShortMessage) o;
        return Objects.equals(text, that.text) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, tags);
    }
}
