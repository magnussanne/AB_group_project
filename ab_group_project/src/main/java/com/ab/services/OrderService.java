package com.ab.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ab.entities.Orders;
import com.ab.repositories.OrderRepository;

public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<Orders> displayOrders(int userId){
		return orderRepository.ordersFromUser(userId);
	}
}