package com.ab.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.ab.entities.Orders;
import com.ab.services.OrderService;
import com.ab.services.UserService;

@RestController
@SessionAttributes("userId")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;

	
	// options being listed from user's dashboard
	@GetMapping("/dashboard")
	public String displayOptions(){
		return "dashboard";
	}
	
	// when user selects option to view all their orders
	@RequestMapping(value="/dashboard", method = RequestMethod.POST)
	public ModelAndView allOrders(
			@PathVariable("userId") int userId
			) {
		List<Orders> order = orderService.displayOrders(userId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("order",order);
		mv.setViewName("redirect:/allorders/"+userId); 
		return mv;
	}

}
