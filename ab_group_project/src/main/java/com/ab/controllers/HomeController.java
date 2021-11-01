package com.ab.controllers;

import java.security.SecureRandom;

import com.ab.entities.Users;
import com.ab.services.JPAService;
import com.ab.services.OrderService;
import com.ab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private JPAService jpaService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/microsoft", method = RequestMethod.GET)
    public String getMicrosoft() {
        return "microsoft";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }

    @RequestMapping(value = "/useraccount", method = RequestMethod.GET)
    public String getUserAccount() {
        return "afterForm";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationScreen() {

        return "registration";

    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String postRegistration(@RequestParam("email") String email, @RequestParam("username") String username,
            @RequestParam("password") String password) {
        int strength = 5;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        Users user = new Users(email, username, encodedPassword);
        jpaService.saveUser(user);

        return "login1";
    }

    @RequestMapping(value = "/login1", method = RequestMethod.GET)
    public String getLoginScreen() {
        return "login1";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        Users user = userService.checkUser(username, password);
        System.out.println(user.getEmail());

        return "dashboard";
    }

}
