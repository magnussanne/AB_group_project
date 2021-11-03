package com.ab.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ab.entities.OrderType;
import com.ab.entities.Orders;
import com.ab.entities.Stocks;
import com.ab.services.JPAService;
import com.ab.services.OrderService;
import com.ab.services.StockService;
import com.ab.services.UserService;

@Controller
public class StockController {

	@Autowired
	private StockService stockService;

	@Autowired
	private UserService userService;

	@Autowired
	private JPAService jpaService;

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/buystock", method = RequestMethod.GET)
	public String buypage(@RequestParam("stockName") String stockName, Model m) {
//		stockService.saveStocks();
		m.addAttribute("stockName", stockName);
		List<Stocks> stock = stockService.getStock(stockName);
		ModelAndView mv = new ModelAndView();
//		mv.addObject("stock", stock);
		m.addAttribute("stock", stock);
		mv.setViewName("stock");
		return "buypage";
	}

	@RequestMapping(value = "/sellstock", method = RequestMethod.GET)
//	public String sellpage(@RequestParam("pictureURL") String pictureURL, Model m, String stockName) {
	public String sellpage(@RequestParam("stockName") String stockName, Model m) {
		m.addAttribute("stockName", stockName);
		List<Stocks> stock = stockService.getStock(stockName);
		m.addAttribute("stock", stock);

		return "sellpage";
	}

	@RequestMapping(value = "/stock/{stockName}", method = RequestMethod.GET)
	public String getstock(@PathVariable("stockName") String stockName, Model m) {
		m.addAttribute("stock", stockService.getStock(stockName));
		m.addAttribute("stockName", stockName);
		List<Stocks> stock = stockService.getStock(stockName);
		ModelAndView mv = new ModelAndView();
		mv.addObject("stock", stock);
		mv.setViewName("stock");
		return "stock";
	}

	@RequestMapping(value = "/buystock/{stockName}", method = RequestMethod.POST)
	public String buyform(@PathVariable("stockName") String stockName, @RequestParam Map<String, String> formDetails) {
		Orders order = new Orders(OrderType.BUY, LocalDateTime.now(), stockName,
				Double.parseDouble(formDetails.get("bidPrice")), userService.getCurrentUser(),
				Integer.parseInt(formDetails.get("quantity")), "Not Completed");
		Stocks stock = stockService.getSingleStock(stockName);
//		System.out.println(stock);
		if (stockService.buyStock(order, stock)) {
			System.out.println("Stock has been purchased");
			order.setStatus("Completed");
			int newAvailable = stock.getAvailable() - order.getQuantity();
			stockService.updateStock(stock, newAvailable);
			jpaService.saveOrder(order);
			// System.out.println(orderService.displayOrders(userService.getCurrentUser().getUserId()));
		} else {
			System.out.println("Purchased declined");
		}
		return "redirect:/orders";
	}

	
	@RequestMapping(value = "/sellstock/{stockName}", method = RequestMethod.POST)
	public String sellform(@PathVariable("stockName") String stockName, @RequestParam Map<String, String> formDetails) {
		Orders order = new Orders(OrderType.SELL, LocalDateTime.now(), stockName,
				Double.parseDouble(formDetails.get("askPrice")), userService.getCurrentUser(),
				Integer.parseInt(formDetails.get("quantity")), "Not Completed");
		Stocks stock = stockService.getSingleStock(stockName);
//		System.out.println(stock);
		if (stockService.sellStock(order, stock)) {
			System.out.println("Stock has been sold");
			order.setStatus("Completed");
			int newAvailable = stock.getAvailable() - order.getQuantity();
			stockService.updateStock(stock, newAvailable);
			jpaService.saveOrder(order);
			// System.out.println(orderService.displayOrders(userService.getCurrentUser().getUserId()));
		} else {
			System.out.println("Sell declined");
		}
		return "redirect:/orders";
	}
	
	
	
	
	
	
	
}
