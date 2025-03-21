package com.poly.recruiterproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcCofig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get(System.getProperty("user.dir"), "uploads/photos/recruiter");
        System.out.println("Đường dẫn" + uploadDir);
        String uploadPath = uploadDir.toUri().toString();
        System.out.println("Đường dẫn 2: " + uploadPath);

        registry.addResourceHandler("/photos/recruiter/**")
                .addResourceLocations(uploadPath);
    }
}
