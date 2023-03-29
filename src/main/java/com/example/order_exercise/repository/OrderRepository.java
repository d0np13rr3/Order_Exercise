package com.example.order_exercise.repository;

import com.example.order_exercise.domain.Amount;
import com.example.order_exercise.domain.Order;
import com.example.order_exercise.dto.ItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class OrderRepository {

    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);
    private static final HashMap<String, Order> repository = new HashMap<>();
    public OrderRepository(){
        Amount amount00 = new Amount(5);
        amount00.setInStock(true);
        ItemDTO dummyItem02 = new ItemDTO("The Dwarves: Triumph", "Novel", 10.0, amount00, 4);
        Order order00 = new Order(dummyItem02, 2);
        repository.put(dummyItem02.getName(), order00);
    }
    public Collection<Order> findAll(){
        return repository.values();
    }

    public Order create(ItemDTO item, Order order){
        repository.put(item.getName(), order);
        return order;
    }
    }


