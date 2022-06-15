package com.exam.battleship.web;

import com.exam.battleship.model.entity.dto.UserLoginDTO;
import com.exam.battleship.model.entity.dto.UserRegisterDTO;
import com.exam.battleship.model.entity.service.UserServiceModel;
import com.exam.battleship.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(Model model){
        if (!model.containsAttribute("isFound")) {
            model.addAttribute("isFound", true);
        }

        return "login";
    }

    @PostMapping("/login")
    public String confirmLogin(@Valid @ModelAttribute UserLoginDTO userLoginDTO,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes,
                               HttpSession httpSession){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userLoginDTO",
                    bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel =
                userService.findUserByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword());

        if (userServiceModel == null){
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("isFound", false);

            return "redirect:login";
        }

        httpSession.setAttribute("user", userServiceModel);

        return "redirect:/";
    }


    @GetMapping("/register")
    public String register(Model model){

        if(!model.containsAttribute("userRegisterDTO")){
            model.addAttribute("userRegisterDTO", new UserRegisterDTO());
        }
        return "register";
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid @ModelAttribute("userRegisterDTO") UserRegisterDTO userRegisterDTO,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors() || !userRegisterDTO.getPassword().equals(
                userRegisterDTO.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDTO",
                    bindingResult);

            return "redirect:register";
        }

        UserServiceModel userServiceModel = modelMapper.map(userRegisterDTO, UserServiceModel.class);

        userService.registerUser(userServiceModel);

        return "redirect:login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();

        return "redirect:/";
    }

    @ModelAttribute
    public UserLoginDTO UserLoginDTO(){
        return new UserLoginDTO();
    }
}
