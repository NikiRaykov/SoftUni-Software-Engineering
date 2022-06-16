package bg.softuni.battleships.service;

import bg.softuni.battleships.model.User;
import bg.softuni.battleships.model.dto.UserLoginDTO;
import bg.softuni.battleships.model.dto.UserRegisterDTO;
import bg.softuni.battleships.repository.UserRepository;
import bg.softuni.battleships.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private CurrentUser currentUser;

    @Autowired
    public UserService(UserRepository userRepository,
                       CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public UserLoginDTO findUserByUsernameAndPassword(String username, String password) {
        User userByUsernameAndPassword = this.userRepository.findByUsernameAndPassword(username, password);
        if (userByUsernameAndPassword == null) {
            return null;
        }

        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setUsername(userByUsernameAndPassword.getUsername());
        userLoginDTO.setPassword(userByUsernameAndPassword.getPassword());
        return userLoginDTO;
    }

    public void login(UserLoginDTO userLogin) {
        this.currentUser.setLoggedIn(true);
        this.currentUser.setUsername(userLogin.getUsername());
    }

    public void register(UserRegisterDTO userRegister) {
        User user = new User();
        user.setUsername(userRegister.getUsername());
        user.setFullName(userRegister.getFullName());
        user.setEmail(userRegister.getEmail());
        user.setPassword(userRegister.getPassword());
        this.userRepository.save(user);
    }

    public void logout() {
        this.currentUser.clear();
    }
}
