package com.ab.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.ab.entities.Orders;
import com.ab.services.OrderService;

@RestController
@SessionAttributes("userId")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	// displaying the user's orders based on the user Id
	@GetMapping("/allorders/{userId}")
	public ModelAndView viewOrders(
			@PathVariable("userId") int userId
			) {
		List<Orders> order = orderService.displayOrders(userId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("order",order);
		mv.setViewName("orderhistory");
		return mv;
	}
	
}
