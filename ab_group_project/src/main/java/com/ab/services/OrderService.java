package com.ab.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.OrderType;
import com.ab.entities.Orders;
import com.ab.entities.Users;
import com.ab.entities.UsersStocks;
import com.ab.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public List<Orders> displayOrders(int userId) {
		System.out.println("*******TESTING****");
		System.out.println(orderRepository.ordersFromUser(userId));
		System.out.println(userId);
		return orderRepository.ordersFromUser(userId);
	}

	public void addOrder(Orders order) {
		orderRepository.save(order);
	}

	public void deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);
	}

	public List<Orders> getOrdersByStock(String stockName) {
		return orderRepository.ordersFromStock(stockName);
	}

	public ArrayList<UsersStocks> getUserWallet(Users user) {
		ArrayList<UsersStocks> ownedStocks = new ArrayList<>();
		List<Orders> orders = displayOrders(user.getUserId());
		UsersStocks microsoft = new UsersStocks("microsoft", 0);
		UsersStocks disney = new UsersStocks("disney", 0);
		UsersStocks apple = new UsersStocks("apple", 0);
		UsersStocks tesla = new UsersStocks("tesla", 0);
		UsersStocks bitcoin = new UsersStocks("bitcoin", 0);
		UsersStocks amd = new UsersStocks("amd", 0);
		ownedStocks.add(microsoft);
		ownedStocks.add(disney);
		ownedStocks.add(apple);
		ownedStocks.add(tesla);
		ownedStocks.add(bitcoin);
		ownedStocks.add(amd);
		for (Orders order : orders) {
			if (order.getOrderType().equals("BUY")) {
				for (UsersStocks stock : ownedStocks) {
					if (stock.getStock().equals(order.getStockName())) {
						int usersQuantity = order.getQuantity();
						System.out.println("User quantity: " + usersQuantity);
						usersQuantity += stock.getQuantity();
						System.out.println("User quantity: " + usersQuantity);
						stock.setQuantity(usersQuantity);
					}
				}
			} else {
				for (UsersStocks stock : ownedStocks) {
					if (stock.getStock().equals(order.getStockName())) {
						int stockQuantity = stock.getQuantity();
						stockQuantity -= order.getQuantity();
						stock.setQuantity(stockQuantity);
					}
				}
			}
		}
		return ownedStocks;
	}
}