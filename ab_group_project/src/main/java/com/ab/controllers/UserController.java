package com.ab.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.ab.entities.Orders;
import com.ab.services.OrderService;
import com.ab.services.UserService;

@Controller
@SessionAttributes("userId")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;

	
	// options being listed from user's dashboard
	/*
	 * @RequestMapping(value="/dashboard",method=RequestMethod.GET) public String displayOptions(){ return "dashboard";
	 * }
	 */
	
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
