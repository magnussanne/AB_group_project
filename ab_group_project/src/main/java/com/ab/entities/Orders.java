package com.ab.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	public Orders(int orderId, OrderType orderType, LocalDateTime dateOfOrder, String stockName) {
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.dateOfOrder = dateOfOrder;
		this.stockName = stockName;
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

	@Override
	public String toString() {
		return "Order ID: " + orderId + " Order Type: " + orderType + " Date of Order: " + dateOfOrder + " Stock Name: "
				+ stockName;
	}

}
