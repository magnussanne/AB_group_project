package com.ab.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ab.entities.Users;
import com.ab.services.OrderService;


@Controller
public class HomeController {
	
	@Autowired
	OrderService orderService;


    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getHome() {
        return "home";
    }
    
    
    @RequestMapping(value="/stock/{stockName}", method=RequestMethod.GET)
    public String getstock(
    		@PathVariable("stockName") String stockName, Model m ) {
    	//ModelAndView mv = new ModelAndView();
    	m.addAttribute("orders",orderService.getOrdersByStock(stockName));
    	m.addAttribute("pictureURL","/"+stockName+".png");
        //mv.setViewName("stock");
        return "stock";
    }
    
    
	/*
	 * @RequestMapping(value="/orders", method=RequestMethod.GET) public String
	 * getOrders() { return "orders"; }
	 */
    
    
    @RequestMapping(value="/useraccount", method=RequestMethod.GET)
    public String getUserAccount() {
        return "useraccount";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String getRegistrationScreen() {
  	
    	return "registration";

  }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String postRegistration(@RequestParam("email") String email, @RequestParam("username") String username, @RequestParam("password") String password) {
        
    	Users user = new Users(email, username, password, null);
    	
    	return "login1";

    }
    
    @RequestMapping(value="/login1", method=RequestMethod.GET)
    public String getLoginScreen() {
  	
    	return "login1";

  }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String postLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        
    	Users user = new Users(null, username, password, null);
    	
    	return "home";

    }
    
    @RequestMapping(value="/buystock",method=RequestMethod.GET)
    public String buypage() {
    	return "buypage";
    }
    
    @RequestMapping(value="/sellstock",method=RequestMethod.GET)
    public String sellpage() {
    	return "sellpage";
    }
    
	/*
	 * @RequestMapping(value="/dashboard", method=RequestMethod.GET) public String
	 * displayOptions(){ return "dashboard"; }
	 */
}
