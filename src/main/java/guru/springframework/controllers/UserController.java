package guru.springframework.controllers;

import guru.springframework.commands.UserCommand;
import guru.springframework.domain.User;
import guru.springframework.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/register")
    public String getRegistrationPage(Model model){
        model.addAttribute("user",new UserCommand());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerUser(@ModelAttribute UserCommand userCommand, Model model){
        User user = service.saveUser(userCommand);
        model.addAttribute("user",user);
        return "redirect:/";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLoginPage(Model model){
        model.addAttribute("user",new UserCommand());
        model.addAttribute("title","Login");
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginUser(@ModelAttribute UserCommand userCommand){
        User user = service.getUserByUserName(userCommand.getUsername());
        if(user.getUsername().equals(userCommand.getUsername()) && user.getPassword().equals(userCommand.getPassword())){
            return "redirect:/";
        }
        return "login";
    }
}