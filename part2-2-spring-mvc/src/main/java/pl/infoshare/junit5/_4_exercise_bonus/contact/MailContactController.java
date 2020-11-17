package pl.infoshare.junit5._4_exercise_bonus.contact;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.junit5._4_exercise_bonus.model.MailContact;

import java.util.List;

@RestController
public class MailContactController {

    private final MailContactRepository mailContactRepository;

    public MailContactController(MailContactRepository mailContactRepository) {
        this.mailContactRepository = mailContactRepository;
    }

    @GetMapping("/contacts")
    public List<MailContact> findContacts() {
        return mailContactRepository.findAll();
    }

    @PostMapping("/contacts")
    public MailContact createContact(@RequestBody MailContact contact) {
        return mailContactRepository.save(contact);
    }

    @DeleteMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        mailContactRepository.deleteById(id);
    }

}