package com.ab.repositories;

import com.ab.entities.Stocks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stocks, Integer> {

    // @Query("SELECT o from Stocks o WHERE o.stock.stockId =:sId")
    // public Stocks findStock(@Param("sId") int stockId);

}