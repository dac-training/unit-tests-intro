package pl.infoshare.junit5._1_exercise;

/**
 * Ćwiczenie 1. Napisz testy dla poniższej klasy. Pamiętaj, żeby uwzględnić wszystkie przypadki.
 */
public class Person {

    private final String name;
    private final String surname;
    private final Integer age;
    private final Gender gender;

    public Person(String name, String surname, Integer age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getFullName() {
        return String.format("%s %s %s", gender.getPrefix(), name, surname);
    }

    public boolean isAdult() {
        return age >= 18;
    }
}
