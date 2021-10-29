package com.ab.services;

import com.ab.entities.Orders;
import com.ab.entities.Stocks;
import com.ab.entities.Users;
import com.ab.repositories.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stocks getStock(String stockName) {
        return stockRepository.findStock(stockName);
    }

    public Boolean buyStock(Orders order, Stocks stock) {
        if (stock.getAvailable() > order.getQuantity() && stock.getBuyPrice() <= order.getPrice()) {
            int available = stock.getAvailable();
            available -= order.getQuantity();
            return true;
        } else {
            return false;
        }
    }

    public Boolean sellStock(Orders order, Stocks stock) {
        if (stock.getSellPrice() == order.getPrice()) {
            int available = stock.getAvailable();
            available += order.getQuantity();
            return true;
        } else {
            return false;
        }
    }
}
