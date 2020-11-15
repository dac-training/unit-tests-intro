package pl.infoshare.junit5.company;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredCompanyController {

    private final CompanyDeleteService companyDeleteService;

    public SecuredCompanyController(CompanyDeleteService companyDeleteService) {
        this.companyDeleteService = companyDeleteService;
    }

    @DeleteMapping("/companies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('REMOVER')")
    public void deleteCompany(@PathVariable String id) {
        companyDeleteService.delete(id);
    }
}
