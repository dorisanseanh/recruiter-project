package com.poly.recruiterproject.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "index";

    }
}
