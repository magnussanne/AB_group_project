package com.ab.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.ab.entities.Orders;
import com.ab.entities.Users;
import com.ab.services.OrderService;
import com.ab.services.UserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller

@SessionAttributes({ "order", "userId", "session_user" })

public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;
	// displaying the user's orders based on the user Id

	@RequestMapping(value = "/orders", method = RequestMethod.GET)

	public ModelAndView viewOrders(Model model) {
		Users user = userService.getCurrentUser();
		model.addAttribute("session_user", user);
		List<Orders> order = orderService.displayOrders(user.getUserId());
		ModelAndView mv = new ModelAndView();
		mv.addObject("order", order);
		mv.setViewName("orders");
		return mv;
	}

	@RequestMapping(value = "/cancelOrder", method = RequestMethod.GET)
	public String cancelOrder() {
		return "cancelorder";
	}

}