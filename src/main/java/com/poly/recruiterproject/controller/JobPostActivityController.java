package com.poly.recruiterproject.controller;

import com.poly.recruiterproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobPostActivityController {
    private final UserService userService;

    @Autowired
    public JobPostActivityController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String jobPostActivity(Model model) {
        Object currentUserProfile = userService.getCurrentUserService();
        return "dashboard";
    }
}
