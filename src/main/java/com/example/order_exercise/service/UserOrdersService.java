package com.example.order_exercise.service;

import com.example.order_exercise.domain.ItemGroup;
import com.example.order_exercise.domain.Order;
import com.example.order_exercise.domain.UserOrders;
import com.example.order_exercise.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;

@Service
public class UserOrdersService {
    private final OrderRepository repository;
    public UserOrdersService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order create(Order order){
        repository.create(order);
        return order;

    }
    public Collection<Order> findAll() {
        return repository.findAll();
    }

    public UserOrders overviewUserOrders(){
        Collection<Order> orders = repository.findAll();
        Order[] orderArray = new Order[orders.size()];
        int itr_OrderArray = 0;
        for(Order o : orders){
            Array.set(orderArray, itr_OrderArray, o);
            itr_OrderArray ++;
        }
        return new UserOrders(orderArray);

    }
}
