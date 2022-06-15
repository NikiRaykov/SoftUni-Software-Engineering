package com.exam.battleship.model.entity.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserLoginDTO {

    public UserLoginDTO(){}

    @Length(min = 5, max = 20, message = "Username length must be between 5 and 20 characters.")
    private String username;

    @Length(min = 3, message = "Password length must be more than 3 characters long.")
    @NotNull
    private String password;

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
}
