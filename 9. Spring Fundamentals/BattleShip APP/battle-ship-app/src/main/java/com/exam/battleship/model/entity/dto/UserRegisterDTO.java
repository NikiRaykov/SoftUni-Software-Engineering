package com.exam.battleship.model.entity.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserRegisterDTO {

    public UserRegisterDTO() {
    }

    @Length(min = 5, max = 20, message = "Username length must be between 5 and 20 characters.")
    private String username;

    @Length(min = 5, max = 20, message = "Enter valid full name")
    private String fullName;

    @Email
    private String email;

    @Length(min = 3, message = "Password length must be more than 3 characters long.")
    @NotNull
    private String password;

    @Length(min = 3, message = "Password length must be more than 3 characters long.")
    @NotNull
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
