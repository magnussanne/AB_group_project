package com.ab.repositories;

import com.ab.entities.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

	@Query("SELECT o from Orders o WHERE o.user.userId =:uId")
	public List<Orders> ordersFromUser(@Param("uId") int userId);

	@Query("SELECT o from Orders o WHERE o.stockName=:stockName")
	public List<Orders> ordersFromStock(String stockName);
}