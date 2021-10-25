package com.ab.controllers;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> parent of 3ddfc64 (changes to html and css)

@RestController
public class HomeController {

<<<<<<< HEAD
    @RequestMapping(value="/", method = RequestMethod.GET)
=======
    @GetMapping("/")
>>>>>>> parent of 3ddfc64 (changes to html and css)
    public String getHome() {
        return "home";

    }
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard() {
    	return "dashboard";
    }

}
