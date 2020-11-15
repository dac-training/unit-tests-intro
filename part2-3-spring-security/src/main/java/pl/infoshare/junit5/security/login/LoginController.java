package pl.infoshare.junit5.security.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserToken> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.of(loginService.login(loginRequest.getUsername(), loginRequest.getPassword()));
    }
}
