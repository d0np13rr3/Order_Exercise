package com.example.order_exercise.controller;

import com.example.order_exercise.domain.Order;
import com.example.order_exercise.domain.TotalOrder;
import com.example.order_exercise.service.ItemService;
import com.example.order_exercise.service.LoginService;
import com.example.order_exercise.service.OrderService;
import com.example.order_exercise.service.TotalOrderService;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ItemService itemService;
    private final OrderService orderService;
    private final TotalOrderService totalOrderService;
    private final LoginService loginService;

    public OrderController(ItemService itemService, OrderService orderService, TotalOrderService totalOrderService, LoginService loginService) {
        this.itemService = itemService;
        this.orderService = orderService;
        this.totalOrderService = totalOrderService;
        this.
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

    @GetMapping("/orderoverview")
    public TotalOrder orderOverview(){
        List<Order> orders = orderService.findAll();
        Order[] orderArray = new Order[orders.size()];
        int itr_Order = 0;
        for(Order o : orders){
            Array.set(orderArray, itr_Order, o);
            itr_Order ++;
        }
        TotalOrder totalOrder = totalOrderService.create(orderArray);
        totalOrder.setCustomerName("Pierre");
        return totalOrder;
    }


}
