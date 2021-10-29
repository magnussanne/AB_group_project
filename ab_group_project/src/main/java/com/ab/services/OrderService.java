package com.ab.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.OrderType;
import com.ab.entities.Orders;
import com.ab.entities.Users;
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
}