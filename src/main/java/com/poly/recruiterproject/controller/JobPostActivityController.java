package com.poly.recruiterproject.controller;
import com.poly.recruiterproject.entity.JobPostActivity;
import com.poly.recruiterproject.entity.Users;
import com.poly.recruiterproject.service.JobPostActivityService;
import com.poly.recruiterproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class JobPostActivityController {
    private final UserService userService;
    private final JobPostActivityService jobPostActivityService;

    @Autowired
    public JobPostActivityController(UserService userService, JobPostActivityService jobPostActivityService) {
        this.userService = userService;
        this.jobPostActivityService = jobPostActivityService;
    }

    @GetMapping("/dashboard/")
    public String jobPostActivity(Model model) {
        Object currentUserProfile = userService.getCurrentUserService();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            model.addAttribute("username", currentUsername);
        }
        model.addAttribute("user", currentUserProfile);

        return "dashboard";
    }

    @GetMapping("/dashboard/add")
    public String getJobPostActivity(Model model) {
        model.addAttribute("jobPostActivity", new JobPostActivity());
        model.addAttribute("user", userService.getCurrentUserService());
        return "add-jobs";
    }
    @PostMapping("/dashboard/addNew")
    public String addNew (JobPostActivity jobPostActivity, Model model) {
        Users user = userService.getCurrentUser();
        if (user != null) {
            jobPostActivity.setPostedById(user);}
        jobPostActivity.setPostedDate(new Date());
        model.addAttribute("jobPostActivity", jobPostActivity);
        JobPostActivity saved = jobPostActivityService.save(jobPostActivity);
        return "redirect:/dashboard/";

    }
}
