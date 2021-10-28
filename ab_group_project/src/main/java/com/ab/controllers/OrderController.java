package com.ab.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.ab.entities.Orders;
import com.ab.services.OrderService;

@Controller

@SessionAttributes({"order","userId"})

public class OrderController {

	@Autowired
	private OrderService orderService;
	
	// displaying the user's orders based on the user Id

	@RequestMapping(value="/orders", method = RequestMethod.GET)

	public ModelAndView viewOrders(
			//@ModelAttribute("userId") int userId
			) {
		List<Orders> order = orderService.displayOrders(1); // userId instead of 1
		ModelAndView mv = new ModelAndView();
		mv.addObject("order",order);
		mv.setViewName("orders");
		return mv;
	}
	
	/*
	 * @ModelAttribute("userId") public Integer userId() { return 0; }
	 */
	
}