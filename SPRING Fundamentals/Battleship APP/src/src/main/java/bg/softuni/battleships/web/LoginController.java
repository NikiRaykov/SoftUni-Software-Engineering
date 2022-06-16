package bg.softuni.battleships.web;

import bg.softuni.battleships.model.dto.UserLoginDTO;
import bg.softuni.battleships.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        if (!model.containsAttribute("userLogin")) {
            model.addAttribute("userLogin", new UserLoginDTO());
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userLogin") UserLoginDTO userLogin,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLogin", userLogin);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLogin", bindingResult);
            return "redirect:/login";
        }

        UserLoginDTO userByUsernameAndPassword = this.userService
                .findUserByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());
        if (userByUsernameAndPassword == null) {
            redirectAttributes.addFlashAttribute("incorrectData", 1);
            return "redirect:/login";
        }

        this.userService.login(userLogin);
        return "redirect:/home";
    }
}
