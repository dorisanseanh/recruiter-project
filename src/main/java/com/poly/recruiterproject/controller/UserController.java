package com.poly.recruiterproject.controller;


import com.poly.recruiterproject.entity.UsersType;
import com.poly.recruiterproject.entity.Users;
import com.poly.recruiterproject.service.UserService;
import com.poly.recruiterproject.service.UsersTypeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UsersTypeService usersTypeService;
    private final UserService usersService;

    @Autowired
    public UserController(UsersTypeService usersTypeService, UserService usersService) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }


    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersType = usersTypeService.getAllUsersTypes();
        model.addAttribute("getAllTypes", usersType);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Validated Users user, Model model) {
        Optional<Users> userByEmail = usersService.getByEmail(user.getEmail());
        if (userByEmail.isPresent()) {
            model.addAttribute("error", "Email already in registed, try to register again with other email.");
            System.out.println("Error: " + model.getAttribute("error"));
            List<UsersType> usersType = usersTypeService.getAllUsersTypes();
            model.addAttribute("getAllTypes", usersType);
            model.addAttribute("user", new Users());
            return "register";
        }
        usersService.addNew(user);
        return "redirect:/dashboard/ ";

    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }


}
