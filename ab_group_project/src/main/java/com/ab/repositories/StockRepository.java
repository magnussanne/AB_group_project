package com.ab.repositories;

import com.ab.entities.Stocks;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stocks, Integer> {

    @Query("SELECT s from Stocks s WHERE s.name =:sName")
    public List<Stocks> findStock(@Param("sName") String name);

    @Query("SELECT s from Stocks s WHERE s.name =:sName")
    public Stocks findStockObject(@Param("sName") String name);

    @Transactional
    @Modifying
    @Query("UPDATE Stocks a set a.available = :available where a.name = :sName")
    public void updateStock(@Param("available") int available, @Param("sName") String name);
}