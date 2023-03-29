package com.example.order_exercise.service;

import com.example.order_exercise.domain.Order;
import com.example.order_exercise.dto.ItemDTO;
import com.example.order_exercise.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
    public List<Order> findAll() {
        return repository.findAll()
                .stream()
                .toList();
    }

    public Order create(ItemDTO item, int amountInOrder) {
        Order newOrder = new Order(item, amountInOrder);
        return repository.create(item, newOrder);
    }
}
