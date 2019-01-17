package model;

public class User {
    private String username;
    private String role;
    private String password;

    public User(){}

    public User(String username, String role, String password) {
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isNotNull(){
        return !(username.isEmpty() && password.isEmpty() && role.isEmpty());
    }

    @Override
    public String toString() {
        return username;
    }
}
