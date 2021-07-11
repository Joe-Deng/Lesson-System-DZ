package com.org.pojo;

public class UserStudent {
    private String username;
    private String password;

    public UserStudent(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserStudent() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
