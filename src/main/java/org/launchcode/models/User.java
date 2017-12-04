package org.launchcode.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    private int id;

    @NotNull
    @Size(min = 5, max = 15)
    private String userName;

    @Email
    private String email;

    @NotNull
    @Size(min = 1)
    private String password;

    private static int nextId = 0;

    public User() {
        updateNextId();
        this.id = nextId;
    }

    private static void updateNextId() {
        nextId = nextId++;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
