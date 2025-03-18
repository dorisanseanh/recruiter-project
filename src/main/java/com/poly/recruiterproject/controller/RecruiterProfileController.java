package com.poly.recruiterproject.controller;

import com.poly.recruiterproject.entity.RecruiterProfile;
import com.poly.recruiterproject.entity.Users;
import com.poly.recruiterproject.service.RecruiterProfileService;
import com.poly.recruiterproject.service.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/recruiter-profile")
public class RecruiterProfileController {
    private final RecruiterProfileService recruiterProfileService;
    private final UserService userService;

    public RecruiterProfileController(RecruiterProfileService recruiterProfileService, UserService userService) {
        this.recruiterProfileService = recruiterProfileService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String recruiterProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            Users users = userService.getByEmail(currentUsername).orElseThrow(() -> new UsernameNotFoundException("Couldn't find user"));
            Optional<RecruiterProfile> recruiterProfile = recruiterProfileService.getOne(users.getUserId());
            if (recruiterProfile.isPresent()) {
                model.addAttribute("profile", recruiterProfile.get());
            }
        }
        return "recruiter_profile";
    }
}
