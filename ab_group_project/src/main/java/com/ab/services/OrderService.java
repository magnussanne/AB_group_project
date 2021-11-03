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
		UsersStocks microsoft = new UsersStocks("Microsoft", 0);
		UsersStocks disney = new UsersStocks("Disney", 0);
		UsersStocks apple = new UsersStocks("Apple", 0);
		UsersStocks tesla = new UsersStocks("Tesla", 0);
		UsersStocks bitcoin = new UsersStocks("Bitcoin", 0);
		UsersStocks amd = new UsersStocks("AMD", 0);
		ownedStocks.add(microsoft);
		ownedStocks.add(disney);
		ownedStocks.add(apple);
		ownedStocks.add(tesla);
		ownedStocks.add(bitcoin);
		ownedStocks.add(amd);
		// for (Orders order : orders) {
		System.out.println("Order: " + orders);
		// }
		for (Orders order : orders) {
			if (order.getOrderType() == OrderType.BUY) {
				for (UsersStocks stock : ownedStocks) {
					if (stock.getStock().equals(order.getStockName())) {
						System.out.println("Order quantity: " + order.getQuantity());
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
						int usersQuantity = order.getQuantity();
						usersQuantity -= stock.getQuantity();
						stock.setQuantity(usersQuantity);
					}
				}
			}
		}
		return ownedStocks;
	}
}