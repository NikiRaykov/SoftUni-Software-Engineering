package com.example.workshop.service.impl;

import com.example.workshop.model.entity.User;
import com.example.workshop.model.service.UserServiceModel;
import com.example.workshop.repository.UserRepository;
import com.example.workshop.service.RoleService;
import com.example.workshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        userServiceModel.setRole(this.roleService
                .findByName(this.userRepository.count() == 0 ? "ADMIN" : "USER"));

        User user = this.modelMapper.map(userServiceModel, User.class);

       return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);

    }
}
