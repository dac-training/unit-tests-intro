package pl.infoshare.junit5._5_exercise.company;

public class CompanyWithTaxNumberAlreadyExists extends RuntimeException {

    private final String taxIdentificationNumber;

    public CompanyWithTaxNumberAlreadyExists(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }
}
