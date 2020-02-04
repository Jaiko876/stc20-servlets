package com.inno.pojo;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private String phone;

    public User() {
    }

    public User(int id, String login, String password, String email, String phone) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
