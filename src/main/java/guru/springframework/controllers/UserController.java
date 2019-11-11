package guru.springframework.controllers;

import guru.springframework.commands.UserCommand;
import guru.springframework.domain.User;
import guru.springframework.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String getRegistrationPage(Model model){
        model.addAttribute("user",new UserCommand());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(Model model, @ModelAttribute("user") @Valid UserCommand userCommand, Errors errors){
        if(errors.hasErrors()){
            log.info("In the error block of registerUser in UserController");
            return "register";
        }
        User user = service.saveUser(userCommand);
        model.addAttribute("user",user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("user",new UserCommand());
        model.addAttribute("title","Login");
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") @Valid UserCommand userCommand, Errors errors){
        if(errors.hasErrors()){
            log.info("In the error block of registerUser in UserController");
            return "login";
        }
        User user = service.getUserByUserName(userCommand.getUsername());
        if(user.getUsername().equals(userCommand.getUsername()) && user.getPassword().equals(userCommand.getPassword())){
            return "redirect:/";
        }
        return "login";
    }
}