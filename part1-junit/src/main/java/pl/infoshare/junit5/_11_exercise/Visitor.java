package pl.infoshare.junit5._11_exercise;

public class Visitor {

    private final String name;
    private final Integer age;

    public Visitor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}