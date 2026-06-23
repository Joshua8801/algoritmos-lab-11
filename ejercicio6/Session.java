package ejercicio6;

public class Session {

    private String token;
    private String username;
    private String role;
    private long expiresAt;

    public Session(String token, String username, String role, long expiresAt) {
        this.token = token;
        this.username = username;
        this.role = role;
        this.expiresAt = expiresAt;
    }
    
    public String getToken() {
        return token;
    }

    public boolean expired() {
        return System.currentTimeMillis() > expiresAt;
    }
    @Override
    public String toString() {
        return "(" + token + ", " + username + ", " + role + ")";
    }
}
