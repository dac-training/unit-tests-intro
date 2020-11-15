package pl.infoshare.junit5.security.user;

public class CurrendaUser {

    private final String username;
    private final String password;
    private final String secretToken;
    private final String role;

    public CurrendaUser(String username, String password, String secretToken, String role) {
        this.username = username;
        this.password = password;
        this.secretToken = secretToken;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getSecretToken() {
        return secretToken;
    }
}
