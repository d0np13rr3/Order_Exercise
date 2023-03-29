package com.example.order_exercise.service;

import com.example.order_exercise.domain.Order;
import com.example.order_exercise.domain.TotalOrder;
import org.springframework.stereotype.Service;

@Service
public class TotalOrderService {

    public TotalOrder create(Order... orderList){
        TotalOrder totalOrder = new TotalOrder(orderList);
        return totalOrder;

    }
}
