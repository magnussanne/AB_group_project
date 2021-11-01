package com.ab.repositories;

import com.ab.entities.Stocks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stocks, Integer> {

    @Query("SELECT s from Stocks s WHERE s.name =:sName")
    public List<Stocks> findStock(@Param("sName") String name);

}