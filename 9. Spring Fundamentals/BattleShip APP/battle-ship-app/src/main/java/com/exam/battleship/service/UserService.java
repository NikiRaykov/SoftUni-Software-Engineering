package com.exam.battleship.service;

import com.exam.battleship.model.entity.service.UserServiceModel;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
}
