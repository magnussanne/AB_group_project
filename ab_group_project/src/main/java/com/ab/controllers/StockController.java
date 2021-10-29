package com.ab.controllers;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ab.entities.OrderType;
import com.ab.entities.Orders;
import com.ab.entities.Stocks;
import com.ab.services.StockService;

@Controller
public class StockController {

	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/buystock", method = RequestMethod.GET)
	public String buypage(@RequestParam("pictureURL") String pictureURL, Model m, String stockName) {
		m.addAttribute("pictureURL", pictureURL);
		List<Stocks> stock = stockService.getStock(stockName);
		ModelAndView mv = new ModelAndView();
		mv.addObject("stock", stock);
		mv.setViewName("stock");
		return "buypage";
	}

	@RequestMapping(value = "/sellstock", method = RequestMethod.GET)
	public String sellpage(@RequestParam("pictureURL") String pictureURL, Model m, String stockName) {
		m.addAttribute("pictureURL", pictureURL);

		return "sellpage";
	}

	@RequestMapping(value = "/stock/{stockName}", method = RequestMethod.GET)
	public String getstock(@PathVariable("stockName") String stockName, Model m) {
		m.addAttribute("stock", stockService.getStock(stockName));
		m.addAttribute("pictureURL", "/" + stockName + ".png");
		List<Stocks> stock = stockService.getStock(stockName);
		ModelAndView mv = new ModelAndView();
		mv.addObject("stock", stock);
		mv.setViewName("stock");
		return "stock";
	}

	@RequestMapping(value = "/buystock", method = RequestMethod.POST)
	public String buyform(@RequestParam("quantity") int quantity, @RequestParam("bidprice") double bidPrice) {
		// Orders order = new Orders(OrderType.BUY, LocalDateTime.now(), stockName,
		// bidPrice, user, quantity,
		// "Not Completed");
		return "stock";
	}

}
