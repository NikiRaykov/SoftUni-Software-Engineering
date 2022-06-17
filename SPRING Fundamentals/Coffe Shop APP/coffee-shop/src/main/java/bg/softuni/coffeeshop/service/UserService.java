package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.entity.User;
import bg.softuni.coffeeshop.model.entity.service.UserServiceModel;
import bg.softuni.coffeeshop.model.entity.view.OrderViewModel;
import bg.softuni.coffeeshop.model.entity.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
