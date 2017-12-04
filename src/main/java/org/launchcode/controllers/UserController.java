package org.launchcode.controllers;

import org.launchcode.models.User;
import org.launchcode.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @RequestMapping(value = "/add")
    public static String displayAddUser(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public static String processAddUser(@ModelAttribute @Valid User user, Errors errors, Model model, @RequestParam String verify) {

        if (errors.hasErrors() || !user.getPassword().equals(verify)) {
            model.addAttribute("title", "Add User");
            model.addAttribute("user", user);
            model.addAttribute("passwordError", "The passwords provided don't match!");
            return "user/add";
        }
        UserData.addUser(user);
        return "redirect:";
    }

    @RequestMapping(value = "")
    public static String index(Model model) {
        List<User> users = UserData.getUsers();
        model.addAttribute("users", users);
        return "user/index";
    }

}
