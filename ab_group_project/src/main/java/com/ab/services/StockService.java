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

    public Stocks getSingleStock(String stockName) {
        System.out.println(stockRepository.findStockObject(stockName));
        return stockRepository.findStockObject(stockName);
    }

    public void updateStock(Stocks stock, int newAvailable) {
        stockRepository.updateStock(newAvailable, stock.getName());
    }

    public Boolean buyStock(Orders order, Stocks stock) {
        if (stock.getAvailable() > order.getQuantity() && stock.getBuyPrice() <= order.getPrice()) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean sellStock(Orders order, Stocks stock) {
        if (stock.getSellPrice() >= order.getPrice()) {
            return true;
        } else {
            return false;
        }
    }

    public void saveStocks() {
        stockRepository.save(new Stocks("Microsoft", "Technology company", 1344.0, 1555.0, 100000));
        stockRepository.save(new Stocks("Disney", "Entertainment company", 1225.0, 1235.0, 100000));
        stockRepository.save(new Stocks("Apple", "Technology company", 1344.0, 1555.0, 100000));
        stockRepository.save(new Stocks("Tesla", "Electric car company", 1225.0, 1235.0, 100000));
        stockRepository.save(new Stocks("Bitcoin", "Crypto currency", 1344.0, 1555.0, 100000));
        stockRepository.save(new Stocks("AMD", "Semiconductor company", 1344.0, 1555.0, 100000));
    }
}
