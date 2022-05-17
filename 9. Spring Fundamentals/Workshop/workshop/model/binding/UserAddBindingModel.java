package com.example.workshop.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserAddBindingModel {

    @Length(min = 2, max = 10, message = "Username must be between 2 and 10 characters")
    private String username;
    @Length(min = 2, message = "Password must be minimum 2")
    private String password;
    private String confirmPassword;
    @Email
    private String email;

    @Pattern(regexp = "https:\\/\\/github\\.com\\/:+\\/:+",
            message = "Enter git address following this pattern")
    private String git;

    public UserAddBindingModel() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }
}
