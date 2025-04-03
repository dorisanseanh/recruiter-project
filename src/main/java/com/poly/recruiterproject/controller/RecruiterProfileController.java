
package com.poly.recruiterproject.controller;

import com.poly.recruiterproject.entity.RecruiterProfile;
import com.poly.recruiterproject.entity.Users;
import com.poly.recruiterproject.service.RecruiterProfileService;
import com.poly.recruiterproject.service.UserService;
import com.poly.recruiterproject.util.FileUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/recruiter-profile")
public class RecruiterProfileController {
    private static final Logger logger = LoggerFactory.getLogger(RecruiterProfileController.class);

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
            logger.info("Fetching recruiter profile for user: {}", currentUsername);
            Users users = userService.getByEmail(currentUsername)
                    .orElseThrow(() -> {
                        logger.error("User not found: {}", currentUsername);
                        return new UsernameNotFoundException("Couldn't find user");
                    });

            Optional<RecruiterProfile> recruiterProfile = recruiterProfileService.getOne(users.getUserId());
            recruiterProfile.ifPresent(profile -> model.addAttribute("profile", profile));

            logger.info("Recruiter profile loaded successfully for user: {}", currentUsername);
        }
        return "recruiter_profile";
    }

    @PostMapping("/addNew")
    public String addNew(RecruiterProfile recruiterProfile, @RequestParam("image") MultipartFile multipartFile, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            logger.info("Adding new recruiter profile for user: {}", currentUsername);
            Users users = userService.getByEmail(currentUsername)
                    .orElseThrow(() -> {
                        logger.error("User not found: {}", currentUsername);
                        return new UsernameNotFoundException("Couldn't find user");
                    });

            recruiterProfile.setUser(users);
            recruiterProfile.setUserAccountId(users.getUserId());
        }

        model.addAttribute("profile", recruiterProfile);
        String fileName = "";

        String originalFilename = multipartFile.getOriginalFilename();
        if (originalFilename != null && !originalFilename.isEmpty()) {
            fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            recruiterProfile.setProfilePhoto(fileName);
            logger.info("Uploading profile photo: {}", fileName);
        }

        RecruiterProfile savedProfile = recruiterProfileService.addNew(recruiterProfile);
        System.out.println("Current directory: " + System.getProperty("user.dir"));
        String uploadDir = "photos/recruiter/" + savedProfile.getUserAccountId();

        try {
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            logger.info("Profile photo uploaded successfully: {}", fileName);
        } catch (Exception e) {
            logger.error("Error uploading profile photo: {}", e.getMessage(), e);
        }

        logger.info("Recruiter profile added successfully for user: {}", recruiterProfile.getUser().getEmail());
        return "redirect:/dashboard/";
    }
}
