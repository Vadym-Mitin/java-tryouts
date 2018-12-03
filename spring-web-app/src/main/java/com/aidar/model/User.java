package com.aidar.model;

import javafx.beans.DefaultProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Vadym Mitin
 */
public class User {
    @NotBlank(message = "Name is required")
    private String name;

    @Size(min = 1, max = 10, message = "surname should be from 1 to 10 symbols")
    private String surname;

    @Email(message = "email is not valid")
    private String Email;

    public User() {
    }

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        Email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
