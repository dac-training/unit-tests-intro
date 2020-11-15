package pl.infoshare.junit5._1_exercise.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentCreateRequest {

    private final String value;

    @JsonCreator
    public CommentCreateRequest(@JsonProperty("value") String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
