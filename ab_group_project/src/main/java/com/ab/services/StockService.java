package com.ab.services;

import com.ab.entities.Stocks;
import com.ab.repositories.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stocks getStock(String stockName) {
        return stockRepository.findStock(stockName);
    }
}
