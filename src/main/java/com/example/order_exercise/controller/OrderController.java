package com.example.order_exercise.controller;

import com.example.order_exercise.domain.Order;
import com.example.order_exercise.dto.CustomerDTO;
import com.example.order_exercise.service.ItemService;
import com.example.order_exercise.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ItemService itemService;
    private final OrderService orderService;

    public OrderController(ItemService itemService, OrderService orderService) {
        this.itemService = itemService;
        this.orderService = orderService;
    }

    @GetMapping ("/{id}/order/{amountOrdered}")
    //make method in order to add found id in order
    public Order findbyId(@PathVariable int id, @PathVariable int amountOrdered){

        return orderService.create(itemService.findById(id), amountOrdered);
    }
    @GetMapping("/findall")
    public List<Order> findAll(){
        return orderService.findAll();
    }

}
