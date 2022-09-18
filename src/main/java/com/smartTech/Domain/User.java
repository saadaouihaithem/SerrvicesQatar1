package com.smartTech.Domain;

public class User {

    private Integer userId;
    private String Name;
    private String email;
    private String password;

    public User(Integer userId, String Name,  String email, String password) {
        this.userId = userId;
        this.Name = Name;
        this.email = email;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void settName(String firstName) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
