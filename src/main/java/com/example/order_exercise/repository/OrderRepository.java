package com.example.order_exercise.repository;

import com.example.order_exercise.domain.ItemGroup;
import com.example.order_exercise.domain.Order;
import com.example.order_exercise.domain.User;
import com.example.order_exercise.domain.UserOrders;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class OrderRepository {
    private static final HashMap<Integer, Order> repository = new HashMap<>();

    public OrderRepository(){

    }
    public Collection<Order> findAll(){
        return repository.values();
    }

    public Order create(Order order){
        repository.put(order.getIdOfOrder(), order);
        return order;
    }




}
