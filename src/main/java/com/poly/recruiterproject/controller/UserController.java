package com.poly.recruiterproject.controller;


import com.poly.recruiterproject.entity.UsersType;
import com.poly.recruiterproject.entity.Users;
import com.poly.recruiterproject.service.UsersTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UsersTypeService usersTypeService;

    @Autowired
    public UserController(UsersTypeService usersTypeService) {
        this.usersTypeService = usersTypeService;
    }
    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersType = usersTypeService.getAllUsersTypes();
        model.addAttribute("getAllTypes", usersType);
        model.addAttribute("user", new Users());
        return "register";
    }
    @PostMapping("/register/new")
    public String userRegistration(@Validated Users user) {
        System.out.println("User:" +user);
        return "dashboard";

    }
    @GetMapping("/home")
    public String home(Model model) {
        return "index";
    }

}
