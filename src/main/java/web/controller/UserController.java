package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;


import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String getAllUser(Model model){
        List<User> users = userService.getListUser();
        model.addAttribute("users",users);
        return "user/users";
    }

    @GetMapping(value = "users/")
    public String getUser(@RequestParam("id") long id, Model model){
      model.addAttribute("user", userService.readUser(id));
      return "user/showUser";
    }

    @GetMapping(value = "users/new")
    public String getNewUser(Model model){
        model.addAttribute(new User());
        return "user/new";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user){
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("users/edit/")
    public String getUpdateUser(@RequestParam("id") long id, Model model){
       model.addAttribute("user", userService.readUser(id));
       return "user/edit";
    }

    @PostMapping("users/{id}")
    public String updateUser(Model model, @ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("users/delete/")
    public String deleteUser(@RequestParam("id") long id){
        userService.deleteUser(id);
        return "redirect:/";
    }

}
