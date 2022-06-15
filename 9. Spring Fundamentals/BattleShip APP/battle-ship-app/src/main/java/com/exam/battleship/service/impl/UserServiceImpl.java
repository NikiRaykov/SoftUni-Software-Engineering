package com.exam.battleship.service.impl;

import com.exam.battleship.model.entity.User;
import com.exam.battleship.model.entity.service.UserServiceModel;
import com.exam.battleship.repository.UserRepository;
import com.exam.battleship.sec.CurrentUser;
import com.exam.battleship.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);

        return this.modelMapper.map(this.userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return this.userRepository.findUserByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }
}
