package pl.infoshare.junit5._5_exercise.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.pl.NIP;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Company {

    private final Integer id;

    @NotBlank
    @Size(min = 3)
    private final String name;

    @NIP
    @JsonProperty("nip")
    private final String taxIdentificationNumber;

    public Company(Integer id, String name, String taxIdentificationNumber) {
        this.id = id;
        this.name = name;
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }
}
