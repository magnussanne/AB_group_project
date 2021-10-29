package com.ab.services;

import com.ab.entities.Orders;
import com.ab.entities.Stocks;
import com.ab.entities.Users;
import com.ab.repositories.StockRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stocks> getStock(String stockName) {
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
