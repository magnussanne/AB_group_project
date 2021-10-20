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

@Controller
@SessionAttributes("order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/allorders/{userId}", method = RequestMethod.GET)
	public ModelAndView viewOrders(
			@PathVariable("userId") int userId
			) {
		List<Orders> order = orderService.displayOrders(userId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("order",order);
		mv.setViewName("All Orders");
		return mv;
	}
	
}
