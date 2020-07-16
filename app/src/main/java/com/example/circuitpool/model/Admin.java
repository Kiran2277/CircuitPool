package com.example.circuitpool.model;

public class Admin {

    String username;
    String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin(String admin1) {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public Admin() {
    }
}
