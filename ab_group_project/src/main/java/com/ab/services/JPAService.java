package com.ab.services;

import com.ab.repositories.OrderRepository;
import com.ab.repositories.UserRepository;
import com.ab.entities.Users;
import com.ab.entities.Orders;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class JPAService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private OrderRepository orderRepo;

    public void saveUser(Users a) {

        userRepo.save(a);

    }

    public void saveOrders(Set<Orders> orders) {

        for (Orders o : orders) {
            orderRepo.save(o);
        }

    }

    public List<Orders> getAllOrders() {

        return orderRepo.findAll();
    }
}
