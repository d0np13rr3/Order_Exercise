package com.example.order_exercise.service;

import com.example.order_exercise.domain.ItemGroup;
import com.example.order_exercise.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Order create(ItemGroup... itemGroupList){
        Order order = new Order(itemGroupList);
        return order;

    }
}
