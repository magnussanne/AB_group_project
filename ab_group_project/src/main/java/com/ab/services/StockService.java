package com.ab.services;

import com.ab.entities.Stocks;
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
}
