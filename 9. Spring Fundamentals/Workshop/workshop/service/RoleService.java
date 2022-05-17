package com.example.workshop.service;

import com.example.workshop.model.service.RoleServiceModel;

public interface RoleService {

    RoleServiceModel findByName(String name);
}
