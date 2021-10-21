package com.ab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "home";

    }

    @GetMapping("/user")
    public String regUser() {

        return "Regular User Page";
    }

    @GetMapping("/admin")
    public String adminUser() {

        return "ADMIN User Page";
    }

}
