package com.ab.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private OrderType orderType;
	private LocalDateTime dateOfOrder;
	private String stockName;
	private Double price;
	private int quantity;
	private String status;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

	public Orders() {

	}

	public Orders(int orderId, OrderType orderType, LocalDateTime dateOfOrder, String stockName, Double price,
			Users user, int quantity, String status) {
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.dateOfOrder = dateOfOrder;
		this.stockName = stockName;
		this.price = price;
		this.user = user;
		this.quantity = quantity;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public LocalDateTime getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(LocalDateTime dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Users getUsers() {
		return user;
	}

	public void setUsers(Users user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order ID: " + orderId + " Order Type: " + orderType + " Date of Order: " + dateOfOrder + " Stock Name: "
				+ stockName + " Price: " +price + " Users: " + user;
	}

}
