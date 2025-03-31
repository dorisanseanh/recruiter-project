package com.poly.recruiterproject.controller;

import com.poly.recruiterproject.entity.JobPostActivity;
import com.poly.recruiterproject.service.JobPostActivityService;
import com.poly.recruiterproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobSeekerApplyController {
    private final JobPostActivityService jobPostActivityService;
    private final UserService userService;

    @Autowired
    public JobSeekerApplyController(JobPostActivityService jobPostActivityService, UserService userService) {
        this.jobPostActivityService = jobPostActivityService;
        this.userService = userService;
    }

    @GetMapping("job-details-apply/{id}")
    public String jobDetailApply(@PathVariable("id") int id, Model model) {
        JobPostActivity jobPostActivity = jobPostActivityService.getOne(id);
        model.addAttribute("jobDetails", jobPostActivity);
        model.addAttribute("user", userService.getCurrentUserService());
        return "job-details";
    }
    @PostMapping("dashboard/edit/{id}")
    public String editJob(@PathVariable("id") int id, Model model) {
        JobPostActivity jobPostActivity = jobPostActivityService.getOne(id);
        model.addAttribute("jobPostActivity", jobPostActivity);
        model.addAttribute("user", userService.getCurrentUserService());
        return "add-jobs";

    }

}
