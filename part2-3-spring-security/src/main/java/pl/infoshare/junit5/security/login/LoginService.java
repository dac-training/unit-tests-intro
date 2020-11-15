package pl.infoshare.junit5.security.login;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5.security.user.CurrendaUserRepository;

import java.util.Optional;

@Component
public class LoginService {

    private final CurrendaUserRepository currendaUserRepository;

    public LoginService(CurrendaUserRepository currendaUserRepository) {
        this.currendaUserRepository = currendaUserRepository;
    }

    public Optional<UserToken> login(String username, String password) {
        return currendaUserRepository.findByUsername(username)
                .filter(u -> u.getPassword().equals(password))
                .map(u -> new UserToken(u.getSecretToken()));
    }
}
