package pl.infoshare.junit5._4_exercise_bonus.mail;

public class MailSendResponse {

    private final MailSendResult result;

    public MailSendResponse(MailSendResult result) {
        this.result = result;
    }

    public MailSendResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "MailSendResponse{" +
                "result=" + result +
                '}';
    }
}
