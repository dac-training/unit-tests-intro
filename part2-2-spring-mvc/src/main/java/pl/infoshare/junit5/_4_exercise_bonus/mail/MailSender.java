package pl.infoshare.junit5._4_exercise_bonus.mail;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void sendMail(String email, String message) {
        System.out.println(String.format("Send message '%s' to: %s", message, email));
    }
}
