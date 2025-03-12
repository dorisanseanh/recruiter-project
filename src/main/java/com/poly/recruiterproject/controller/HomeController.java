//package com.poly.recruiterproject.controller;
//
//import com.poly.recruiterproject.entity.UsersType;
//import com.poly.recruiterproject.service.UsersTypeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//
//import java.util.List;
//
//@Controller
//public class HomeController {
//    private final UsersTypeService usersTypeService;
//
//    @Autowired
//    public HomeController(UsersTypeService usersTypeService) {
//        this.usersTypeService = usersTypeService;
//    }
//
//    public String register(Model model) {
//        List<UsersType> usersTypes = usersTypeService.getAllUsersTypes();
//        model.addAttribute("getAllTypes", usersTypes);
//        model.addAttribute("users", new UsersType());
//        return "register";
//    }
//}
