package com.ab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ab.entities.Users;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "home";

    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationScreen() {

        return "registration";

    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String postRegistration(@RequestParam("email") String email, @RequestParam("username") String username,
            @RequestParam("password") String password) {

        Users user = new Users(email, username, password, null);

        return "login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginScreen() {

        return "login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

        Users user = new Users(null, username, password, null);

        return "home";

    }
}
