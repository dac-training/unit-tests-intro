package pl.infoshare.junit5._4_exercise_bonus.mail;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.infoshare.junit5._4_exercise_bonus.model.Mail;

import javax.validation.Valid;

@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/contacts/{id}/mail")
    public MailSendResponse sendMail(@PathVariable Integer id, @Valid @RequestBody Mail mail) {
        var result = mailService.sendNotification(id, mail);
        return new MailSendResponse(result);
    }


}
