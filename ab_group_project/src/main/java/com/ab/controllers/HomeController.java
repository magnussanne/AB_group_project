package com.ab.controllers;

import com.ab.entities.Users;
import com.ab.services.JPAService;
import com.ab.services.OrderService;
import com.ab.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }


    @RequestMapping(value = "/stock/{stockName}", method = RequestMethod.GET)
    public String getstock(@PathVariable("stockName") String stockName, Model m) {
        m.addAttribute("orders", orderService.getOrdersByStock(stockName));
        m.addAttribute("pictureURL", "/" + stockName + ".png");
        return "stock";
    }

    @RequestMapping(value = "/useraccount", method = RequestMethod.GET)
    public String getUserAccount() {
        return "useraccount";
    }

    @RequestMapping(value = "/microsoft", method = RequestMethod.GET)
    public String getMicrosoft() {
        return "microsoft";

    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationScreen() {

        return "registration";

    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String postRegistration(@RequestParam("email") String email, @RequestParam("username") String username,
            @RequestParam("password") String password) {

        Users user = new Users(email, username, password);
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

        return "home";
    }

    @RequestMapping(value = "/buystock", method = RequestMethod.GET)
    public String buypage(@RequestParam("pictureURL") String pictureURL, Model m) {
    	//@PathVariable("stockName") String stockName, Model m) {
        //m.addAttribute("pictureURL", "/" + stockName + ".png");
    	m.addAttribute("pictureURL", pictureURL);
        return "buypage";
    }

    @RequestMapping(value = "/sellstock", method = RequestMethod.GET)
    public String sellpage(@RequestParam("pictureURL") String pictureURL, Model m) {
    	m.addAttribute("pictureURL", pictureURL);
        return "sellpage";
    }


}
