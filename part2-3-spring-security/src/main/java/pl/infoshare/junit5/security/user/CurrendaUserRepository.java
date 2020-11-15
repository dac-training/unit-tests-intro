package pl.infoshare.junit5.security.user;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CurrendaUserRepository {

    private final List<CurrendaUser> users = new ArrayList<>();

    @PostConstruct
    void init() {
        users.add(new CurrendaUser("maciek", "admin", "12345", "writer"));
        users.add(new CurrendaUser("pacific112", "1234", "my-secret-token", "ROLE_REMOVER"));
    }

    public Optional<CurrendaUser> findByUsername(String username) {
        return users.stream()
                .filter(s -> s.getUsername().equals(username))
                .findFirst();
    }

    public Optional<CurrendaUser> findBySecret(String secret) {
        return users.stream()
                .filter(s -> s.getSecretToken().equals(secret))
                .findFirst();
    }
}
