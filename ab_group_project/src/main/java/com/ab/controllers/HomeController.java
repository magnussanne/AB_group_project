package com.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ab.entities.Users;
import com.ab.services.JPAService;
import com.ab.services.UserService;

@Controller
public class HomeController {

    @Autowired
    private JPAService jpaService;

    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationScreen() {
        return "/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String postRegistration(@RequestParam("email") String email, @RequestParam("username") String username,
            @RequestParam("password") String password) {
        Users user = new Users(email, username, password);
        jpaService.saveUser(user);

        return "/login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginScreen() {

        return "/login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

        userService.checkUser(username, password);

        return "/";

    }
}
